package by.academy.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 25.09.2016.
 */
@Controller
public class MainController {

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        return "main";
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String showTestPage(Model model) {
        return "test";
    }

}
