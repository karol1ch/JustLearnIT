package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Topic;

import java.util.List;

public interface TopicService {

    Topic getTopicByTopicID(int topicID);

    List<Topic> getTopicsByCategoryName(String categoryName);

    List<Topic> getIncompleteTopicsByCategoryAndUsername(Category category, String username);

    void saveOrUpdate(Topic topic);
}
