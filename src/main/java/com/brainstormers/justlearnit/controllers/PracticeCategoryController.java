package com.brainstormers.justlearnit.controllers;


import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.service.CategoryService;
import com.brainstormers.justlearnit.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PracticeCategoryController {

    final
    ProblemService problemService;

    final
    CategoryService categoryService;

    @Autowired
    public PracticeCategoryController(ProblemService problemService, CategoryService categoryService) {
        this.problemService = problemService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/practice/category/{categoryName}", method = RequestMethod.GET)
    public String showCategoryPage(@PathVariable String categoryName, ModelMap model){

        Category category = categoryService.getCategoryByName(categoryName);

        if (category == null) {
            return "redirect:/invalidPage";
        }

        List<Problem> problems = problemService.getPracticeProblemsWhereCategory(category);

        model.addAttribute("category", category);
        model.addAttribute("problems", problems);

        return "practiceCategory";
    }

}
