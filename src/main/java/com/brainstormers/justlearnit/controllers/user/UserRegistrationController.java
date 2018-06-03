package com.brainstormers.justlearnit.controllers.user;

import com.brainstormers.justlearnit.models.User;
import com.brainstormers.justlearnit.service.UserDetailService;
import com.brainstormers.justlearnit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String submitRegistrationForm(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
//no to fajnie, daj potem znać czy pomoglo, elo
        //problem jest taki że Valid odnosci się do obiektu User(który ma userdetails)
        //Ale nie walidujemy userDetails, dlatego nie dostajemy błędów, tylko potem ten duży error
        //dlatego hasło działa (bo jest w userrze, a email z z obiektu detials xd)
        //hmm, @Valid user.userdetials? nie wiem xD obczaj

        if(bindingResult.hasErrors()){
            return "user/registration";
        }

        String mail = user.getUserDetailByUsername().getEmail();

        if(bindingResult.hasFieldErrors(mail)){
            return "user/registration";
        }

        user.setEnabled(1);
        userService.save(user);


        user.getUserDetailByUsername().setUsername(user.getUsername());
        userDetailService.save(user.getUserDetailByUsername());
        return "user/registrationConfirmation";
    }

}
