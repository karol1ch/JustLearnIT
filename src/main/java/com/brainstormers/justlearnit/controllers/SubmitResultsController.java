package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.Submit;
import com.brainstormers.justlearnit.models.SubmitResult;
import com.brainstormers.justlearnit.service.SubmitResultService;
import com.brainstormers.justlearnit.service.SubmitService;
import com.brainstormers.justlearnit.service.TestService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.NoResultException;
import java.util.List;

@Controller
public class SubmitResultsController {

    final
    SubmitService submitService;

    final
    SubmitResultService submitResultService;

    final
    TestService testService;

    public SubmitResultsController(SubmitService submitService, SubmitResultService submitResultService, TestService testService) {
        this.submitService = submitService;
        this.submitResultService = submitResultService;
        this.testService = testService;
    }

    @RequestMapping(value = "/submitResult/{SubmitID}", method = RequestMethod.GET)
    public String showSubmitResultPage(@PathVariable("SubmitID") int submitID, ModelMap model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        System.out.println("user: " + name + ", submitID: " + submitID + ";");

        Submit submit = null;

        try {
            submit = submitService.getSubmitByIDAndUsername(submitID, name);
        } catch (NoResultException e) {
            return "redirect:/invalidPage";
        }

        long testsAmount = testService.getAmountOfTestsByProblemID(submit.getProblem());

        while (submitResultService.getSubmitResultsAmountBySubmitID(submit.getId()) != testsAmount) {

            submit = submitService.getSubmitByID(submit.getId());

            if (submit.getCompilationReturnCode() != null && submit.getCompilationReturnCode().intValue() != 0) {
                model.put("submitID", submitID);
                model.put("compilationError", submit.getCompilationStderr());
                model.put("userCode", submit.getCodeContent());
                model.put("language", submit.getProgrammingLanguage().getName());

                return "submitCompilationError";
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<SubmitResult> submitResultsList = submitResultService.getSubmitResultsBySubmitID(submitID);

        model.put("results", submitResultsList);
        model.put("submitID", submitID);
        model.put("userCode", submit.getCodeContent());
        model.put("language", submit.getProgrammingLanguage().getName());

        return "submitResult";
    }

}
