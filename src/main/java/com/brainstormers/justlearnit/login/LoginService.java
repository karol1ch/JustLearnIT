package com.brainstormers.justlearnit.login;


import com.brainstormers.justlearnit.models.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public boolean validateUser(String username, String password){
        Session session = getSessionFactory().openSession();


        String hql = "FROM PersonEntity WHERE username=\'" + username + "\' AND password=\'" + password + "\'";

        Query query = session.createQuery(hql);
        ArrayList<PersonEntity> list = (ArrayList<PersonEntity>) query.list();
        return list.size() > 0;
    }
}
