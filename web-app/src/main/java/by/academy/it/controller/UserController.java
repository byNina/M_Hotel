package by.academy.it.controller;

import by.academy.it.beans.PaginationDTO;
import by.academy.it.beans.Request;
import by.academy.it.services.IRequestService;
import by.academy.it.services.IUserService;
import by.academy.it.beans.User;
import by.academy.it.constants.AccessLevel;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.constants.MessageConstants;
import by.academy.it.constants.Parameters;
import by.academy.it.managers.ConfigurationManager;
import by.academy.it.managers.MessageManager;
import org.apache.log4j.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 24.09.2016.
 */
@Controller
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IRequestService requestService;

    @RequestMapping(path = "userInfo", method = RequestMethod.GET)
    private String showUserInfo(@RequestParam(value = "userId") Integer userId, ModelMap model) {
        User user;
        user = (User) userService.getUserById(userId);
        if (user != null) {
            model.addAttribute("user_info", user);
        } else {
            log.warn("There is no such user with id=" + userId);
            return "errorPage";
        }
        return "userInfo";
    }

    @RequestMapping(path = "users/login", method = RequestMethod.POST)
    private String login(ModelMap model, HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        if (userService.isAuthorized(login, password)) {
            HttpSession session = request.getSession();
            User user = (User) userService.getUser(login);
            AccessLevel accessLevel = checkAccessLevel(user);
            session.setAttribute(Parameters.ACCESS_LEVEL_ATTRIBUTE, accessLevel);
            session.setAttribute(Parameters.USER, user);
            System.out.println("User" + user + accessLevel);
            switch (accessLevel) {
                case ADMIN:
                    page = "main";
                    session.setAttribute(Parameters.SIDE_BAR, ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_SIDE_BAR));
                    break;
                case USER:
                    page = "main";
                    session.setAttribute(Parameters.SIDE_BAR, ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SIDE_BAR));
                    break;
                default:
            }
        } else {
            page = "errorpage";
            request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
                    MessageManager.INSTANCE.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
        }
        return page;
    }


    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(Model model, HttpServletRequest request) {
        String sideBar = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.GUEST_SIDE_BAR);
        request.getSession().invalidate();
        HttpSession session = request.getSession();
        AccessLevel accessLevel = AccessLevel.GUEST;
        session.setAttribute(Parameters.ACCESS_LEVEL_ATTRIBUTE, accessLevel);
        session.setAttribute(Parameters.SIDE_BAR, sideBar);
        return "main";
    }

    @RequestMapping(path = "users/addUser", method = RequestMethod.POST)
    public String userRegistration(@Valid User user, BindingResult result, ModelMap model, HttpServletRequest request) {
        if (result.hasErrors()) {
            request.setAttribute("errorMessage", MessageManager.INSTANCE.getProperty(MessageConstants.FILDS_HAVE_ERRORS));
            return "registration";
        }
        if (validation(user)) {
            if (!isUserExist(user)) {
                userService.save(user);
                model.addAttribute("user", user);
                return "main";
            } else {
                clearFilds(user);
                request.setAttribute("errorMessage", MessageManager.INSTANCE.getProperty(MessageConstants.USER_EXSISTS));
                return "registration";
            }
        } else {
            clearFilds(user);
            request.setAttribute("errorMessage", MessageManager.INSTANCE.getProperty(MessageConstants.FILDS_HAVE_ERRORS));
            return "registration";
        }
    }

    @RequestMapping(value = "users/showMyRequests", method = RequestMethod.GET)
    public String showMyRequests(Model model, HttpServletRequest request, HttpSession session) {
        List<Request> requests;
        PaginationDTO pagination;
        User user;
        int page = 1;
        if (session.getAttribute("pagination") == null) {
            pagination = new PaginationDTO();
        } else {
            pagination = (PaginationDTO) session.getAttribute("pagination");
        }
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        user = (User) session.getAttribute("user");
        requests = requestService.getUserRequests(user, page, pagination.getPagesize());
        int totalCount = requestService.getTotalCount();
        if (totalCount != 0) {
            int pages = totalCount / pagination.getPagesize() + 1;
            pagination.setPages(pages);
        }
        if (!requests.isEmpty() && (requests != null)) {
            model.addAttribute("requests", requests);
            model.addAttribute("totalcount", totalCount);
            model.addAttribute("page", page);
            session.setAttribute("pagination", pagination);
        } else {
            //  TODO  if users is empty
        }
        return "requests";
    }

    @RequestMapping(value = "users/gotonewrequestcreation", method = RequestMethod.GET)
    public String goToRequestCreation(Model model, HttpServletRequest request) {

        return "newRequest";
    }

    private AccessLevel checkAccessLevel(User user) {
        AccessLevel accessLvl = null;
        Integer accountType = user.getAccountType();
        if (accountType != null) {
            if (AccessLevel.USER.accessLevel() == accountType) {
                accessLvl = AccessLevel.USER;
            } else {
                accessLvl = AccessLevel.ADMIN;
            }
        }
        return accessLvl;
    }

    @RequestMapping(path = "/users/newRequest", method = RequestMethod.POST)
    public String createRequest(Model model, HttpServletRequest request) {
        request.setAttribute("errorMessage", MessageManager.INSTANCE.getProperty(MessageConstants.IN_DEVELOPING));
        return "errorpage";

    }

    private boolean validation(User user) {
        if (checkLogin(user.getLogin().trim()) && checkPassword(user.getPassword().trim())) {
            return true;
        }
        return false;
    }

    public static boolean checkLogin(String userLogin) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_-]{4,10}$");
        Matcher m = p.matcher(userLogin);
        return m.matches();
    }

    public static boolean checkPassword(String userPassword) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_-]{4,10}$");
        Matcher m = p.matcher(userPassword);
        return m.matches();
    }

    private void clearFilds(User user) {
        user.setLogin(null);
        user.setPassword(null);
        user.setAccountType(null);
        user.setUserInfo(null);
    }

    private boolean isUserExist(User newUser) {
        if (newUser != null) {
            User existingUser = (User) userService.getUser(newUser.getLogin().trim());
            if (existingUser == null) {
                return false;
            }
        }
        return true;
    }


}

