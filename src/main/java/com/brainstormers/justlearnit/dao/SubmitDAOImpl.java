package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Submit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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
    public Submit getSubmitByIDAndUsername(int id, String username) {
        Session session = sessionFactory.getCurrentSession();
       // from Problem p where p.category.name = :categoryName"
        Submit submit = (Submit) session.createQuery(
                "from Submit s where s.id = :id and s.user.username = :username"
        )
                .setParameter("id", id)
                .setParameter("username", username)
                .getSingleResult();

        return submit;
    }

    @Override
    public void saveOrUpdate(Submit submit) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(submit);
    }

    @Override
    public List<Submit> getSubmitByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        List<Submit> submits = session.createQuery("from Submit where user.username = :username order by id desc")
                .setParameter("username", username)
                .getResultList();

        return submits;
    }


}
