package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.UserSelectedCategory;
import java.util.List;

public interface UserSelectedCategoryDAO {

    List<UserSelectedCategory> getUserSelectedCategoriesByUsername(String username);

    List<UserSelectedCategory> getUserCompletedCategoriesByUsername(String username);

    List<UserSelectedCategory> getUserUnfinishedCategoriesByUsername(String username);


}
