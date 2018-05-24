package com.brainstormers.justlearnit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.brainstormers.justlearnit.models.UserDetail;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserDetail getUserDetail(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserDetail.class, username);
    }

    @Override
    public void update(UserDetail userDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userDetail);
    }

    @Override
    public UserDetail getUserDetailByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM UserDetail WHERE email=\'" + email + "\'";
        return (UserDetail) session.createQuery(hql).uniqueResult();
    }

    @Override
    public void save(UserDetail userDetailByUsername) {
        Session session = sessionFactory.getCurrentSession();
        session.save(userDetailByUsername);
    }

}
