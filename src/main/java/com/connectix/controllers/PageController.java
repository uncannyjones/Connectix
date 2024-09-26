package com.connectix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.connectix.entities.User;
import com.connectix.forms.UserForm;
import com.connectix.services.userService;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class PageController {
    
    @Autowired
    private userService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

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
    
       // processing register
       @RequestMapping(value = "/do-register", method = RequestMethod.POST)
       public String processRegister(@ModelAttribute UserForm userForm) {
           System.out.println("Processing registration");
           // fetch form data
           // UserForm
           System.out.println(userForm);
           User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .about(userForm.getAbout())
                .phoneNumber(userForm.getPhoneNumber())
                .profPic(
                        "https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.m.wikipedia.org%2Fwiki%2FFile%3ASample_User_Icon.png&psig=AOvVaw2F6Y3Ngm22x4J3QJXklgzH&ust=1727363299274000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCKDU5PCv3ogDFQAAAAAdAAAAABAE")
                .build();
        User savedUser = userService.saveUser(user);
        System.out.println("user saved :");
        // message = "Registration Successful"
        // redirectto login page
        return "redirect:/register";
       }
   
    
}
