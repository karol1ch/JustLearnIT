package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.models.Test;
import com.brainstormers.justlearnit.service.CategoryService;
import com.brainstormers.justlearnit.service.ProblemService;
import com.brainstormers.justlearnit.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.NoResultException;

@Controller
public class ProblemController {

    final
    ProblemService problemService;

    final
    CategoryService categoryService;

    final
    TestService testService;

    @Autowired
    public ProblemController(ProblemService problemService, CategoryService categoryService, TestService testService) {
        this.problemService = problemService;
        this.categoryService = categoryService;
        this.testService = testService;
    }

    @RequestMapping(value = "/{categoryName}/problem/{problemID}", method = RequestMethod.GET)
    public String showCategoryPage(@PathVariable String categoryName, @PathVariable int problemID, ModelMap model) {

        Category category = categoryService.getCategoryByName(categoryName);
        Problem problem = problemService.getProblemById(problemID);
        Test openTest = null;

        if (category == null || problem == null)
        {
            return "redirect:/invalidPage";
        }

        try {
            openTest = testService.getOpenTestByProblemID(problem);
        }
        catch (NoResultException e) {
            openTest = new Test();
        }

        model.addAttribute("problem", problem);
        model.addAttribute("openTest", openTest);

        return "problem";
    }
}
