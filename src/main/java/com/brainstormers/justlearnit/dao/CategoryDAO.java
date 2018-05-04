package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Category;

import java.util.List;

public interface CategoryDAO {

    Category getCategoryById(int theId);

    List<Category> getCategoriesList();
}
