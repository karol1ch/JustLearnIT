package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.ProgrammingLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class ProgrammingLanguageDAOImpl implements ProgrammingLanguageDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public ProgrammingLanguage getProgrammingLangaugeByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(ProgrammingLanguage.class, name);
    }
}
