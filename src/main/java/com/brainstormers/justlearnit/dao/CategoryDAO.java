package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> getCategoriesList();

    Category getCategoryByName(String categoryName);
}
