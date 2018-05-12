package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Category;

import java.util.List;

public interface CategoryService {


    List<Category> getCategoriesList();

    Category getCategoryByName(String categoryName);

    void saveOrUpdate(Category category);

    void delete(Category category);
}
