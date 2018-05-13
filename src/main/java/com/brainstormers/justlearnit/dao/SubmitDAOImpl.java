package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Submit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class SubmitDAOImpl implements SubmitDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Submit getSubmitByID(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Submit.class, id);
    }

    @Override
    public void saveOrUpdate(Submit submit) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(submit);
    }
}
