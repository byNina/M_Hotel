package by.academy.it.controller;

import by.academy.it.beans.ApartmentType;
import by.academy.it.beans.User;
import by.academy.it.constants.Parameters;
import by.academy.it.services.IApartmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by User on 25.09.2016.
 */
@Controller
public class MainController {
    private final String BASENAME = "locale_";

    @Autowired
    private IApartmentTypeService apartmentService;

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        return "main";
    }

    @RequestMapping(value = "**/test", method = RequestMethod.POST)
    public String showTestPage(Model model) {
        return "test";
    }

    @RequestMapping(value = "**/back", method = RequestMethod.GET)
    public String goBack(Model model) {
        return "main";
    }


    @RequestMapping(value = "**/registration", method = RequestMethod.GET)
    public String goToRegistration(ModelMap model) {
        model.put("user", new User());
        return "registration";
    }

    @RequestMapping(value = "**/hotelInfo", method = RequestMethod.GET)
    public String showHotelInfo(Model model) {
        return "hotelInfo";
    }

    @RequestMapping(value = "**/showAllRooms", method = RequestMethod.GET)
    public String showAllRooms(Model model) {
        List<ApartmentType> apartments = null;
        apartments = apartmentService.getAllApartments();
        model.addAttribute("apartments", apartments);
        return "apartmentTypes";
    }

    @RequestMapping(value = "**/setLang", method = RequestMethod.POST)
    public String setLang(Model model, HttpServletRequest request) {
    String page = null;
    String lang = request.getParameter(Parameters.LANG);
    HttpSession session = request.getSession();
	session.setAttribute(Parameters.SESSION_LOCALE_ATTRIBUTE, BASENAME + lang);
    	return "main";
    }


}
