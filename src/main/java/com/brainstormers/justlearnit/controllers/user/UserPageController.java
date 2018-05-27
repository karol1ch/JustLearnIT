package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.dao.UserDetailDAO;
import com.brainstormers.justlearnit.models.User;
import com.brainstormers.justlearnit.models.UserDetail;
import com.brainstormers.justlearnit.service.UserDetailService;
import com.brainstormers.justlearnit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserPageController {

    @Autowired
    UserDetailService userDetailService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userPanel", method = RequestMethod.GET)
    public String userPanel(ModelMap model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        UserDetail userDetail = userDetailService.getUserDetail(name);
        model.addAttribute("userDetail", userDetail);
        return "userPanel";
    }

    @RequestMapping(value = "/editData", method = RequestMethod.GET)
    public String showEditData(ModelMap model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        UserDetail userDetail = userDetailService.getUserDetail(name);
        model.addAttribute("userDetail", userDetail);
        return "editData";
    }

    @RequestMapping(value = "/updateData", method = RequestMethod.POST)
    public String updateData(@ModelAttribute("userDetail") @Valid UserDetail userDetail, BindingResult result, ModelMap modelMap){
        if(result.hasErrors()){
            return "editData";
        }
        String email  = userDetail.getEmail();
        UserDetail tempUser = userDetailService.getUserDetailByEmail(email);
        if( tempUser == null ){
            userDetailService.update(userDetail);
            return "redirect:/userPanel";
        }
        else {
            modelMap.addAttribute("message", "This email address is already in use.");
            return "editData";
        }
    }

    @RequestMapping(value = "/editPassword", method = RequestMethod.GET)
    public String showEditPassword(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "editPassword";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePassword(@ModelAttribute("user")@Valid User user, BindingResult result, ModelMap modelMap){

        if(result.hasErrors()){
            return "editPassword";
        }
        if( !user.getPassword().equals(user.getConfirmPassword())){
            modelMap.addAttribute("message1", "New password and confirm password should be same");
            return  "editPassword";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        User tempUser = userService.getUserById(name);

        if( !tempUser.getPassword().equals(user.getOldPassword())){
            modelMap.addAttribute("message2", " Old password is wrong");
            return "editPassword";
        }

        tempUser.setEnabled(1);
        tempUser.setPassword(user.getPassword());
        tempUser.setOldPassword(user.getPassword());
        tempUser.setConfirmPassword(user.getPassword());
        userService.update(tempUser);
        return "redirect:/userPanel";
    }

}
