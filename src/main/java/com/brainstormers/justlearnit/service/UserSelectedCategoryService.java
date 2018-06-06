package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.UserSelectedCategory;
import com.brainstormers.justlearnit.models.UserSelectedCategoryPK;

import java.util.List;

public interface UserSelectedCategoryService {

    List<UserSelectedCategory> getUserSelectedCategoriesByUsername(String username);

    List<UserSelectedCategory> getUserCompletedCategoriesByUsername(String username);

    List<UserSelectedCategory> getUserUnfinishedCategoriesByUsername(String username);

    UserSelectedCategory getSelectedCategoryByPK(UserSelectedCategoryPK pk);

    void saveOrUpdate(UserSelectedCategory userSelectedCategory);
}
