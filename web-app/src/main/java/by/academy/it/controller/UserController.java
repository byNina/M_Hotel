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

/**
 * Created by User on 24.09.2016.
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRequestService requestService;

    private static Logger log = Logger.getLogger(UserController.class);


    @RequestMapping(path = "**/userInfo", method = RequestMethod.GET)
    private String showUserInfo(@RequestParam(value = "userId") Integer userId, ModelMap model) {
        User user = null;
        System.out.println("userId" + userId);
        user = (User) userService.getUserById(userId);
        System.out.println("user" + user);
        if (user != null) {
            model.addAttribute("user_info", user);
        } else {
            //  TODO  there is no user
        }
        return "userInfo";
    }

    @RequestMapping(path = "/users/login", method = RequestMethod.POST)
    private String login(ModelMap model, HttpServletRequest request) {
        System.out.println("Register");
        String page = null;
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        System.out.println(login + password);
        System.out.println(userService.isAuthorized(login, password));
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
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
                    MessageManager.INSTANCE.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
        }
        return page;
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


    @RequestMapping(value = "**/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpServletRequest request) {
        String sideBar = (String) ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.GUEST_SIDE_BAR);
        request.getSession().invalidate();
        HttpSession session = request.getSession();
        AccessLevel accessLevel = AccessLevel.GUEST;
        session.setAttribute(Parameters.ACCESS_LEVEL_ATTRIBUTE, accessLevel);
        session.setAttribute(Parameters.SIDE_BAR, sideBar);
        return "main";
    }

    @RequestMapping(path = "addUser", method = RequestMethod.POST)
    public String userRegistration(@Valid User user, ModelMap model, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            System.out.println("has valid error");
            return "errorpage";
        }
        if (user != null) {
            userService.save(user);
            model.addAttribute("user", user);
        }
        return "main";
    }

    @RequestMapping(value = "**/showMyRequests", method = RequestMethod.GET)
    public String showMyRequests(Model model, HttpServletRequest request, HttpSession session) {
        List<Request> requests = null;
        PaginationDTO pagination = null;
        User user = null;
        int page = 1;
        if (session.getAttribute("pagination") == null) {
            pagination = new PaginationDTO();
        } else {
            pagination = (PaginationDTO) session.getAttribute("pagination");
        }
        if (request.getParameter("page") != null) {
            System.out.println("page" + page);
            page = Integer.parseInt(request.getParameter("page"));
        }
        user = (User) session.getAttribute("user");
        requests = requestService.getUserRequests(user, page, pagination.getPagesize());
        int totalcount = requestService.getTotalCount();
        System.out.println("totalcount" + totalcount);
        if (totalcount != 0) {
            int pages = totalcount / pagination.getPagesize() + 1;
            pagination.setPages(pages);
        }
        System.out.println("pages" + pagination.getPages());
        if (!requests.isEmpty() && (requests != null)) {
            model.addAttribute("requests", requests);
            model.addAttribute("totalcount", totalcount);
            model.addAttribute("page", page);
            session.setAttribute("pagination", pagination);
        } else {
            //  TODO  if users is empty
        }
        return "requests";
    }

    @RequestMapping(value = "**/gotonewrequestcreation", method = RequestMethod.GET)
    public String goToRequestCreation(Model model, HttpServletRequest request) {

        return "newRequest";
    }
}

