package by.academy.it.controller;

import by.academy.it.beans.PaginationDTO;
import by.academy.it.beans.Request;
import by.academy.it.beans.User;
import by.academy.it.services.IRequestService;
import by.academy.it.services.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by User on 02.10.2016.
 */
@Controller
public class AdminController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRequestService requestService;

    private static Logger log = Logger.getLogger(UserController.class);

    @RequestMapping(path = "getAllUsers", method = RequestMethod.GET)
    private String getAllUsers(ModelMap model) {
        List<User> users;
        users = userService.getAllUsers();
        if ((users != null) && !users.isEmpty()) {
            model.addAttribute("users", users);
        } else {
            //  TODO  if users is empty
        }
        return "getAllUsers";
    }


    @RequestMapping(path = "showRequests", method = RequestMethod.GET)
    private String showAllRequests(ModelMap model, HttpSession session, HttpServletRequest request) {
        List<Request> requests;
        PaginationDTO pagination;
        int page = 1;
        if (session.getAttribute("pagination") == null) {
            pagination = new PaginationDTO();
        } else {
            pagination = (PaginationDTO) session.getAttribute("pagination");
        }
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        requests = requestService.getAllRequests(page, pagination.getPagesize());
        int totalcount = requestService.getTotalCount();
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

    @RequestMapping(path = "pagination", method = RequestMethod.GET)
    private String pagination(ModelMap model, HttpSession session, HttpServletRequest request) {
        String page;
        PaginationDTO pagination;
        int pageSize = Integer.parseInt(request.getParameter("pagesize"));
        if (session.getAttribute("pagination") != null) {
            pagination = (PaginationDTO) session.getAttribute("pagination");
            pagination.setPagesize(pageSize);
        }
        page = showAllRequests(model, session, request);
        return page;
    }

    @RequestMapping(path = "invoiceForm", method = RequestMethod.POST)
    private String toInvoiceForm(ModelMap model) {
        return "invoiceForm";
    }

}
