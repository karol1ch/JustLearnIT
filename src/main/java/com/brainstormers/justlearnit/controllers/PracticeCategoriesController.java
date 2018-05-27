package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PracticeCategoriesController {

    final
    CategoryService categoryService;

    public PracticeCategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/practice/categories", method = RequestMethod.GET)
    public String showCategoryPage(ModelMap model){

        List<Category> categories = categoryService.getCategoriesList();

        model.addAttribute("categories", categories);

        return "practiceCategories";
    }

}
