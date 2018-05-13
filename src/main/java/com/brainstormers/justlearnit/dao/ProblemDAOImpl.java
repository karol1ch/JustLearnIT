package com.brainstormers.justlearnit.dao;


import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProblemDAOImpl implements ProblemDAO{

    @Autowired
    SessionFactory sessionFactory;


    public Problem getProblemById(int theId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Problem.class, theId);

    }

    @Transactional
    public List<Problem> getProblemsList() {
        Session session = sessionFactory.getCurrentSession();
        List<Problem> result = session.createQuery("from Problem ").list();
        return result;
    }


    public void deleteProblem(int problemId) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("delete Problem where id = " + problemId);
        q.executeUpdate();
    }

    @Override
    public void saveOrUpdate(Problem problem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(problem);
    }

    @Override
    public List<Problem> getProblemsWhereCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Problem p where p.category.name = :categoryName");

        query.setParameter("categoryName", category.getName());
        List result = query.list();
        return result;
    }
}
