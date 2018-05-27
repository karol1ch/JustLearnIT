package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TopicDAOImpl implements TopicDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Topic getTopicByTopicID(int topicID) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Topic.class, topicID);
    }

    @Override
    public List<Topic> getTopicsByCategoryName(String categoryName) {
        Session session = sessionFactory.getCurrentSession();
        List<Topic> topics = session.createQuery(
                "from Topic where category.name = :categoryName")
                .setParameter("categoryName", categoryName)
                .getResultList();

        return topics;
    }

    @Override
    public List<Topic> getIncompleteTopicsByCategoryAndUsername(Category category, String username) {
        Session session = sessionFactory.getCurrentSession();

        List<Topic> allTopics = getTopicsByCategoryName(category.getName());

        List<Topic> completedTopics = session.createNativeQuery("select * from topic where category_name = '" + category.getName() + "' and id in (select topic_id from user_completed_topic where username = '" + username + "')"
                , Topic.class).getResultList();

//        List<Topic> completedTopics = session.createQuery(
//                "from Topic as T join UserCompletedTopic as UCT" +
//                        " on UCT.topic.id = T.id where T.category = :category and UCT.username = :username")
//                .setParameter("category", category)
//                .setParameter("username", username)
//                .getResultList();

        allTopics.removeAll(completedTopics); // Now there are only incompleted topics
        return allTopics;
    }
}
