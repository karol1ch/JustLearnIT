package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.UserSelectedCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class UserSelectedCategoryDAOImpl implements UserSelectedCategoryDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<UserSelectedCategory> getUserSelectedCategoriesByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<UserSelectedCategory> selectedCategories = session.createQuery(
                "from UserSelectedCategory where username = :username")
                .setParameter("username", username)
                .list();

        return selectedCategories;
    }

    @Override
    public List<UserSelectedCategory> getUserCompletedCategoriesByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<UserSelectedCategory> completedCategories = session.createQuery(
                "from UserSelectedCategory where username = :username and completed = true")
                .setParameter("username", username)
                .list();

        return completedCategories;
    }

    @Override
    public List<UserSelectedCategory> getUserUnfinishedCategoriesByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        List<UserSelectedCategory> unfinishedCategories = session.createQuery(
                "from UserSelectedCategory where username = :username and completed = false")
                .setParameter("username", username)
                .list();

        return unfinishedCategories;
    }
}
