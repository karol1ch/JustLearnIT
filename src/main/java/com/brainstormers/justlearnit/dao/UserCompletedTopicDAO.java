package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.UserCompletedTopic;

import java.util.List;

public interface UserCompletedTopicDAO {

    UserCompletedTopic getUserCompletedTopicByTopicIDAndUsername(int topicID, String username);

    List<UserCompletedTopic> getUserCompletedTopicsByCategoryAndUsername(Category category, String username);

}
