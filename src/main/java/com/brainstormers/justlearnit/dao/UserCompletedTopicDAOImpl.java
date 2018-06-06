package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.UserCompletedTopic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserCompletedTopicDAOImpl implements UserCompletedTopicDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserCompletedTopic getUserCompletedTopicByTopicIDAndUsername(int topicID, String username) {
        Session session = sessionFactory.getCurrentSession();

        UserCompletedTopic completedTopic = (UserCompletedTopic)session.createQuery(
                "from UserCompletedTopic where topic.id = :topicID and username = :username")
                .setParameter("topicID", topicID)
                .setParameter("username", username)
                .getSingleResult();

        return completedTopic;
    }

    @Override
    public List<UserCompletedTopic> getUserCompletedTopicsByCategoryAndUsername(Category category, String username) {
        Session session = sessionFactory.getCurrentSession();

//        List<UserCompletedTopic> completedTopics = session.createQuery(
//                "from UserCompletedTopic where username = :username and topic IN (from Topic where Topic.category = :category)")
//                .setParameter("category", category)
//                .setParameter("username", username)
//                .getResultList();

        List<UserCompletedTopic> completedTopics = session.createNativeQuery("select * from user_completed_topic where username = '" + username + "' and topic_id in (select id from topic where category_name = '" + category.getName() + "')"
                , UserCompletedTopic.class).getResultList();

        return completedTopics;
    }

    @Override
    public void saveOrUpdate(UserCompletedTopic userCompletedTopic) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(userCompletedTopic);
    }
}
