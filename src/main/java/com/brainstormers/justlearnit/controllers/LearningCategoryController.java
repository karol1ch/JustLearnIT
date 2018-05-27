package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.*;
import com.brainstormers.justlearnit.service.CategoryService;
import com.brainstormers.justlearnit.service.TopicService;
import com.brainstormers.justlearnit.service.UserCompletedTopicService;
import com.brainstormers.justlearnit.service.UserSelectedCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LearningCategoryController {

    final
    CategoryService categoryService;

    final
    TopicService topicService;

    final
    UserCompletedTopicService userCompletedTopicService;

    final
    UserSelectedCategoryService userSelectedCategoryService;

    @Autowired
    public LearningCategoryController(CategoryService categoryService, TopicService topicService,
                                      UserCompletedTopicService userCompletedTopicService,
                                      UserSelectedCategoryService userSelectedCategoryService) {
        this.categoryService = categoryService;
        this.topicService = topicService;
        this.userCompletedTopicService = userCompletedTopicService;
        this.userSelectedCategoryService = userSelectedCategoryService;
    }

    @RequestMapping(value = "/learning/category/{categoryName}", method = RequestMethod.GET)
    public String showCategoryV2Page(@PathVariable String categoryName, ModelMap model){

        Category category = categoryService.getCategoryByName(categoryName);

        if (category == null) {
            return "redirect:/invalidPage";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        if (userSelectedCategoryService.getSelectedCategoryByPK(new UserSelectedCategoryPK(username, category)) == null) {
            userSelectedCategoryService.saveOrUpdate(new UserSelectedCategory(username, category));
        }

        List<UserCompletedTopic> completedTopics =
                userCompletedTopicService.getUserCompletedTopicsByCategoryAndUsername(category, username);

        List<Topic> incompletedTopics =
                topicService.getIncompleteTopicsByCategoryAndUsername(category, username);

        model.put("categoryName", categoryName);
        model.put("categoryDescription", category.getDescription());
        model.put("incompletedTopics", incompletedTopics);
        model.put("completedTopics", completedTopics);

        return "learningCategory";
    }
}
