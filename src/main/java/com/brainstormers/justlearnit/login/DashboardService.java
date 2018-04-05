package com.brainstormers.justlearnit.login;

import com.brainstormers.justlearnit.models.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DashboardService {
    @Autowired
    private SessionFactory sessionFactory;

    private org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public ArrayList<PersonEntity> getListOfPersons(){
        Session session = getSessionFactory().openSession();

        String hql = "FROM PersonEntity ";

        Query query = session.createQuery(hql);
        return  (ArrayList) query.list();
    }
}
