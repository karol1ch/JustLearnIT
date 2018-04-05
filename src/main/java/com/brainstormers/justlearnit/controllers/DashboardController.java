package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.login.DashboardService;
import com.brainstormers.justlearnit.models.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class DashboardController {
    @Autowired
    DashboardService dashboardService;
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboardPageWithPersons(ModelMap model){

        ArrayList<PersonEntity> list = dashboardService.getListOfPersons();

        model.addAttribute("list_of_persons", list);
        return "dashboard";
    }
}
