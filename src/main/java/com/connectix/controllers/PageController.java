package com.connectix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
   

    @RequestMapping("/home")
    public String home(Model model){

        //sending data to view
        System.out.println("Home Page Handler");
        model.addAttribute("Name", "Connectix");
        model.addAttribute("GithubRepo","https://github.com/uncannyjones/Connectix");
        return "home";
    }
}
