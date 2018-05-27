package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.TopicDAO;
import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicDAO topicDAO;

    @Override
    public Topic getTopicByTopicID(int topicID) {
        return topicDAO.getTopicByTopicID(topicID);
    }

    @Override
    public List<Topic> getTopicsByCategoryName(String categoryName) {
        return topicDAO.getTopicsByCategoryName(categoryName);
    }

    @Override
    public List<Topic> getIncompleteTopicsByCategoryAndUsername(Category category, String username) {
        return topicDAO.getIncompleteTopicsByCategoryAndUsername(category, username);
    }
}
