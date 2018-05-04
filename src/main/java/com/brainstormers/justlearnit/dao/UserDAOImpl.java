package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    SessionFactory sessionFactory;


    @Override
    public User getUserById(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, username);
    }
}
