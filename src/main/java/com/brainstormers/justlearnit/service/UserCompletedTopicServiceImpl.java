package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.UserCompletedTopicDAO;
import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.UserCompletedTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserCompletedTopicServiceImpl implements UserCompletedTopicService {

    @Autowired
    UserCompletedTopicDAO userCompletedTopicDAO;


    @Override
    public UserCompletedTopic getUserCompletedTopicByTopicIDAndUsername(int topicID, String username) {
        return userCompletedTopicDAO.getUserCompletedTopicByTopicIDAndUsername(topicID, username);
    }

    @Override
    public List<UserCompletedTopic> getUserCompletedTopicsByCategoryAndUsername(Category category, String username) {
        return userCompletedTopicDAO.getUserCompletedTopicsByCategoryAndUsername(category, username);
    }

    @Override
    public void saveOrUpdate(UserCompletedTopic userCompletedTopic) {
        userCompletedTopicDAO.saveOrUpdate(userCompletedTopic);
    }
}
