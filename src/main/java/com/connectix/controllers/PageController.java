package com.connectix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.connectix.forms.UserForm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



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

    //about
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", false);
        System.out.println("About Page Loading");
        return "about" ;
    }
    

    //services
    @RequestMapping("/services")
    public String aboutServices(){
        System.out.println("Services Page Loading");
        return "Services" ;
    }

    //contact
    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    //login
    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    //register
    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        
        model.addAttribute("userForm", userForm);
        return "register";
    }
    
    //processing register
    @RequestMapping(value="/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("OK Tested");
        return "redirect:/register";
    }
    
}
