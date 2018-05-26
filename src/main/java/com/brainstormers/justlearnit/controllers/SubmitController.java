package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.models.Submit;
import com.brainstormers.justlearnit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;

@Controller
public class SubmitController {

    final
    ProblemService problemService;

    final
    CategoryService categoryService;

    final
    SubmitService submitService;

    final
    ProgrammingLanguageService programmingLanguageService;

    final
    UserService userService;

    final
    TestService testService;

    final
    SubmitResultService submitResultService;

    private Problem problem;

    @Autowired
    public SubmitController(ProblemService problemService, CategoryService categoryService, SubmitService submitService,
                            ProgrammingLanguageService programmingLanguageService, UserService userService, TestService testService, SubmitResultService submitResultService) {
        this.problemService = problemService;
        this.categoryService = categoryService;
        this.submitService = submitService;
        this.programmingLanguageService = programmingLanguageService;
        this.userService = userService;
        this.testService = testService;
        this.submitResultService = submitResultService;
    }

    @RequestMapping(value = "/{categoryName}/submit/{problemID}", method = RequestMethod.GET)
    public String loginForm(@PathVariable("categoryName") String categoryName, @PathVariable("problemID") int problemID, ModelMap model) {

        Category category = categoryService.getCategoryByName(categoryName);
        problem = problemService.getProblemById(problemID);

        if (category == null || problem == null) {
            return "redirect:/invalidPage";
        }

        LinkedList<String> languages = new LinkedList<>();
        languages.add(categoryName); // This is a temporary solution.

        model.put("problemName", problem.getName());
        model.put("ideTheme", null); // This is a temporary solution.
        model.put("languages", languages);

        Submit submit = new Submit();

        model.addAttribute("submit", submit);

        return "submit";
    }

    @RequestMapping(value = "/submitCode", method = RequestMethod.POST)
    public String userSubmitCode(@ModelAttribute("submit") Submit submit, Model model) {

        System.out.println(submit.toString());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        submit.setProblem(problem);
        submit.setUser(userService.getUserById(auth.getName()));
        submit.setReceivedTime(Timestamp.valueOf(LocalDateTime.now()));
        submitService.saveOrUpdate(submit);

        long testsAmount = testService.getAmountOfTestsByProblemID(problem);

        do {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            submit = submitService.getSubmitByID(submit.getId());

            if (submit.getCompilationReturnCode() != null && submit.getCompilationReturnCode().intValue() != 0) {
                break;
            }

        } while (submitResultService.getSubmitResultsAmountBySubmitID(submit.getId()) != testsAmount);


        return "redirect:/submitResult/" + submit.getId();
    }
}
