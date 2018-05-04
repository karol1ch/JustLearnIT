package com.brainstormers.justlearnit.service;


import com.brainstormers.justlearnit.dao.CategoryDAO;
import com.brainstormers.justlearnit.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public Category getCategoryById(int theId) {
        return categoryDAO.getCategoryById(theId);
    }

    @Override
    public List<Category> getCategoriesList() {
        return categoryDAO.getCategoriesList();
    }
}
