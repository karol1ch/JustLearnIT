package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.SubmitResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SubmitResultDAOImpl implements SubmitResultDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<SubmitResult> getSubmitResultsBySubmitID(int submitID) {
        Session session = sessionFactory.getCurrentSession();
        List<SubmitResult> submitResultsList = session.createQuery(
                "from SubmitResult where submitId = " + submitID
        ).list();

        return submitResultsList;
    }

    @Override
    public long getSubmitResultsAmountBySubmitID(int submitID) {
        Session session = sessionFactory.getCurrentSession();
        long count = (long)session.createQuery(
                "select count(*) from SubmitResult login where submitId = :submitID")
                .setParameter("submitID", submitID)
                .getSingleResult();

        return count;
    }

}
