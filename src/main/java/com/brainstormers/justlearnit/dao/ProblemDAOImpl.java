package com.brainstormers.justlearnit.dao;


import com.brainstormers.justlearnit.models.Problem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
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
}
