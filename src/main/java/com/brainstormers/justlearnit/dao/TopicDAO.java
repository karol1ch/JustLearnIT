package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Topic;

import java.util.List;

public interface TopicDAO {

    Topic getTopicByTopicID(int topicID);

    List<Topic> getTopicsByCategoryName(String categoryName);

    List<Topic> getIncompleteTopicsByCategoryAndUsername(Category category, String username);
}
