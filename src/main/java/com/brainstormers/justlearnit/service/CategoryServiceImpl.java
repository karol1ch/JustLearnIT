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
    public List<Category> getCategoriesList() {
        return categoryDAO.getCategoriesList();
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryDAO.getCategoryByName(categoryName);
    }
}
