package com.brainstormers.justlearnit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @RequestMapping(value = "/loginForm")
    public String loginForm(){

        return "login";
    }


}
