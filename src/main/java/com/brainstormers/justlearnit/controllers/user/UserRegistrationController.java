package com.brainstormers.justlearnit.controllers.user;

import com.brainstormers.justlearnit.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRegistrationController {


    @RequestMapping("register")
    public String registrationForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/registration";
    }


    @PostMapping("submitRegistrationForm")
    public String submitRegistrationForm(){
        return "dashboard";
    }

}
