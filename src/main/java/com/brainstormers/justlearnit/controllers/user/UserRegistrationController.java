package com.brainstormers.justlearnit.controllers.user;

import com.brainstormers.justlearnit.models.User;
import com.brainstormers.justlearnit.service.UserDetailService;
import com.brainstormers.justlearnit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRegistrationController {


    final
    UserService userService;

    final
    UserDetailService userDetailService;

    @Autowired
    public UserRegistrationController(UserService userService, UserDetailService userDetailService) {
        this.userService = userService;
        this.userDetailService = userDetailService;
    }

    @RequestMapping("register")
    public String registrationForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/registration";
    }

    @PostMapping("submitRegistrationForm")
    public String submitRegistrationForm(@ModelAttribute("user") User user){
        user.setEnabled(1);
        userService.save(user);
        user.getUserDetailByUsername().setUsername(user.getUsername());
        userDetailService.save(user.getUserDetailByUsername());
        return "user/registrationConfirmation";
    }

}
