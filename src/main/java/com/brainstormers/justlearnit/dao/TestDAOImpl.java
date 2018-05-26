package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.models.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TestDAOImpl implements TestDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Test getTestByID(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Test.class, id);
    }

    @Override
    public Test getTestByProblemIDAndNumber(Problem problem, int number) {
        Session session = sessionFactory.getCurrentSession();
        Test test = (Test) session.createQuery(
                "from Test where problemByProblemId = " + problem.getId() + " and number = " + number
        ).getSingleResult();

        return test;
    }

    @Override
    public List<Test> getTestsByProblemID(Problem problem) {
        Session session = sessionFactory.getCurrentSession();
        List<Test> tests = session.createQuery("from Test where problemByProblemId = " + problem.getId()).list();

        return tests;
    }

    @Override
    public Test getOpenTestByProblemID(Problem problem) {
        Session session = sessionFactory.getCurrentSession();
        Test openTest = (Test) session.createQuery(
                "from Test where problemByProblemId = " + problem.getId() + " and is_open IS TRUE"
        ).getSingleResult();

        return openTest;
    }

    @Override
    public long getAmountOfTestsByProblemID(Problem problem) {
        Session session = sessionFactory.getCurrentSession();
        long count = (long)session.createQuery(
                "select count(*) from Test login where problemByProblemId = :problem")
                .setParameter("problem", problem)
                .getSingleResult();

        return count;
    }

}
