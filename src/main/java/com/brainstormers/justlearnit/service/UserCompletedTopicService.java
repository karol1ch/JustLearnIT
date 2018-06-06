package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.UserCompletedTopic;

import java.util.List;

public interface UserCompletedTopicService {

    UserCompletedTopic getUserCompletedTopicByTopicIDAndUsername(int topicID, String username);

    List<UserCompletedTopic> getUserCompletedTopicsByCategoryAndUsername(Category category, String username);

    void saveOrUpdate(UserCompletedTopic userCompletedTopic);

}
