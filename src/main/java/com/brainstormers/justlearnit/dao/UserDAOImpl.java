package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.User;
import com.brainstormers.justlearnit.service.UserDetailService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {


    @Autowired
    SessionFactory sessionFactory;


    @Override
    public User getUserById(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, username);
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

}

