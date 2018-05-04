package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(int theId);

    List<Category> getCategoriesList();

}
