package com.brainstormers.justlearnit.controllers;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Topic;
import com.brainstormers.justlearnit.models.UserCompletedTopic;
import com.brainstormers.justlearnit.service.CategoryService;
import com.brainstormers.justlearnit.service.TopicService;
import com.brainstormers.justlearnit.service.UserCompletedTopicService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.NoResultException;

@Controller
public class TopicController {

    final
    CategoryService categoryService;

    final
    TopicService topicService;

    final
    UserCompletedTopicService userCompletedTopicService;

    String categoryName;
    int topicID;


    public TopicController(CategoryService categoryService, TopicService topicService, UserCompletedTopicService userCompletedTopicService) {
        this.categoryService = categoryService;
        this.topicService = topicService;
        this.userCompletedTopicService = userCompletedTopicService;
    }

    @RequestMapping(value = "/{categoryName}/theory/{topicID}", method = RequestMethod.GET)
    public String getTheoryPage(@PathVariable("categoryName") String categoryName, @PathVariable("topicID") int topicID, ModelMap model) {

        Category category = categoryService.getCategoryByName(categoryName);
        Topic topic = topicService.getTopicByTopicID(topicID);

        this.categoryName = categoryName;
        this.topicID = topicID;

        if (category == null || topic == null) {
            return "redirect:/invalidPage";
        }

        model.put("topic", topic);

        return "theory";
    }

    @RequestMapping(value = "/{categoryName}/example/{topicID}", method = RequestMethod.GET)
    public String getExamplePage(@PathVariable("categoryName") String categoryName, @PathVariable("topicID") int topicID, ModelMap model) {

        Category category = categoryService.getCategoryByName(categoryName);
        Topic topic = topicService.getTopicByTopicID(topicID);

        this.categoryName = categoryName;
        this.topicID = topicID;

        if (category == null || topic == null) {
            return "redirect:/invalidPage";
        }

        model.put("topic", topic);

        return "codeExamples";
    }

    @RequestMapping(value = "/FinishLesson", method = RequestMethod.POST)
    public String finishLesson(ModelMap model) {

        Category category = categoryService.getCategoryByName(categoryName);
        Topic topic = topicService.getTopicByTopicID(topicID);

        if (category == null || topic == null) {
            return "redirect:/invalidPage";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        UserCompletedTopic userCompletedTopic = null;

        try {
            userCompletedTopic = userCompletedTopicService.getUserCompletedTopicByTopicIDAndUsername(topicID, username);
        }
        catch (NoResultException e) {
            userCompletedTopic = new UserCompletedTopic();
            userCompletedTopic.setTopic(topic);
            userCompletedTopic.setUsername(username);
            userCompletedTopic.setPercentageScore(100);
        }

        userCompletedTopicService.saveOrUpdate(userCompletedTopic);

        return "redirect:/learning/category/" + this.categoryName;
    }
}
