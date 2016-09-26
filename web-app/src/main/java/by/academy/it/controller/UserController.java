package by.academy.it.controller;

import by.academy.it.IUserService;
import by.academy.it.beans.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by User on 24.09.2016.
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    private static Logger log = Logger.getLogger(UserController.class);

    @RequestMapping(path = "getAllUsers", method = RequestMethod.GET)
    private String getAllUsers (ModelMap model) {
        List<User> users = null;
        users = userService.getAllUsers();
        System.out.println("users" + users);
       if(!users.isEmpty() && (users != null)) {
             model.addAttribute("users", users);
       }else {
         //  TODO  if users is empty
       }
        return "getAllUsers";
    }



}
