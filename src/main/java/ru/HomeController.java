package ru;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @author Zateev Aleksey
 */

@Controller
public class HomeController {


    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("personData", new PersonData());
        return "index";
    }
}
