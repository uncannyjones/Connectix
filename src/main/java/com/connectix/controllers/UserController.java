package com.connectix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        System.out.print("user dashboard");
        return "user/dashboard";
    }

    @RequestMapping(value = "/profile")
    public String userProfile() {
        System.out.print("user profile");
        return "user/profile";
    }
    
    
}
