package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.models.User;
import com.brainstormers.justlearnit.service.CategoryService;
import com.brainstormers.justlearnit.service.ProblemService;
import com.brainstormers.justlearnit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    final
    ProblemService problemService;

    final
    UserService userService;

    final
    CategoryService categoryService;

    @Autowired
    public AdminController(ProblemService problemService, UserService userService, CategoryService categoryService) {
        this.problemService = problemService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "adminDashboard";
    }

    @RequestMapping("/categories")
    public String categories(Model model){
        List<Category> categories = categoryService.getCategoriesList();
        model.addAttribute("categories", categories);
        return "categoriesAdmin";
    }

    @RequestMapping("/problems")
    public String problems(Model model){
       List<Problem> problems = problemService.getProblemsList();
        model.addAttribute("problems", problems);
        return "problems";
    }

    @GetMapping("/deleteProblem")
    public String deleteProblem(@RequestParam(name = "problemId") int problemId){

        problemService.deleteProblem(problemId);

        return "redirect:/admin/problems";
    }


    @RequestMapping("/addProblem")
    public String addProblem(Model model){
        Problem problem = new Problem();
        List<Category> categories = categoryService.getCategoriesList();


        List<String> categoriesNames = new ArrayList<>();
        for (Category c: categories){
            categoriesNames.add(c.getName());
        }

        model.addAttribute("problem", problem);
        model.addAttribute("categories", categoriesNames);

        return "addProblemForm";
    }

    @GetMapping("/saveProblem")
    public String saveProblem(@ModelAttribute Problem problem){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        String categoryName = problem.getCategory().getName();

        User user = userService.getUserById(name);
        Category category = categoryService.getCategoryByName(categoryName);

        problem.setUser(user);
        problem.setCategory(category);

        problemService.saveOrUpdate(problem);
        return "redirect:/admin/problems";
    }

    @RequestMapping(value = "/addCategoryForm", method = RequestMethod.GET)
    public String addCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "addCategoryForm";
    }


    @GetMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") Category category){
        categoryService.saveOrUpdate(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(name = "categoryName") String categoryName){
        Category category = categoryService.getCategoryByName(categoryName);
        categoryService.delete(category);

        return "redirect:/admin/categories";
    }

}
