package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Category> getCategoriesList() {
        Session session = sessionFactory.getCurrentSession();

        List<Category> result = session.createQuery("from Category ").list();

        return result;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Category.class, categoryName);
    }

    @Override
    public void saveOrUpdate(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public void delete(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }


}
