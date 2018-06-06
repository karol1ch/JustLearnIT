package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.UserSelectedCategory;
import com.brainstormers.justlearnit.service.UserSelectedCategoryService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DashboardController {

    final
    UserSelectedCategoryService userSelectedCategoryService;

    public DashboardController(UserSelectedCategoryService userSelectedCategoryService) {
        this.userSelectedCategoryService = userSelectedCategoryService;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboardPageWithPersons(ModelMap model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username

        List<UserSelectedCategory> completedCategories =
                userSelectedCategoryService.getUserCompletedCategoriesByUsername(username);

        List<UserSelectedCategory> unfinishedCategories =
                userSelectedCategoryService.getUserUnfinishedCategoriesByUsername(username);

        model.put("username", username);
        model.put("completedCategories", completedCategories);
        model.put("unfinishedCategories", unfinishedCategories);


        return "dashboard";
    }
}
