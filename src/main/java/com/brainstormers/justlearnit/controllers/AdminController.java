package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.models.Topic;
import com.brainstormers.justlearnit.models.Test;
import com.brainstormers.justlearnit.models.User;
import com.brainstormers.justlearnit.service.CategoryService;
import com.brainstormers.justlearnit.service.ProblemService;
import com.brainstormers.justlearnit.service.TopicService;
import com.brainstormers.justlearnit.service.TestService;
import com.brainstormers.justlearnit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    final
    TestService testService;

    final
    TopicService topicService;

    @Autowired
    public AdminController(ProblemService problemService, UserService userService, CategoryService categoryService, TestService testService, TopicService topicService) {
        this.problemService = problemService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.testService = testService;
        this.topicService = topicService;
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

    @RequestMapping("/addLesson")
    public String lessons(Model model){

        List<Category> categories = categoryService.getCategoriesList();

        List<String> categoriesNames = new ArrayList<>();
        for (Category c: categories){
            categoriesNames.add(c.getName());
        }

        model.addAttribute("categories", categoriesNames);
        model.addAttribute("lesson", new Topic());
        return "addLesson";
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

    @GetMapping("/saveLesson")
    public String saveLesson(@ModelAttribute Topic topic){

        topicService.saveOrUpdate(topic);

        return "redirect:/admin/addLesson";
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

    @RequestMapping ("/problemDetails/{problemId}")
    public String problemDetails(@PathVariable int problemId, Model model){

        Problem problem = problemService.getProblemById(problemId);
        model.addAttribute("problem", problem);
        return "admin/problemDetails";
    }

    @RequestMapping("/problemTests/{problemId}")
    public String problemTests(@PathVariable int problemId, ModelMap model){

        Problem problem = problemService.getProblemById(problemId);
        List<Test> tests = testService.getTestsByProblemID(problem);
        model.put("problemName", problem.getName());
        model.addAttribute("tests", tests);
        return "admin/problemTests";
    }

}
