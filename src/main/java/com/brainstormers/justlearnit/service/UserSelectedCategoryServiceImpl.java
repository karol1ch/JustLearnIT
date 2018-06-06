package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.UserSelectedCategoryDAO;
import com.brainstormers.justlearnit.models.UserSelectedCategory;
import com.brainstormers.justlearnit.models.UserSelectedCategoryPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSelectedCategoryServiceImpl implements UserSelectedCategoryService {

    @Autowired
    UserSelectedCategoryDAO userSelectedCategoryDAO;

    @Override
    public List<UserSelectedCategory> getUserSelectedCategoriesByUsername(String username) {
        return userSelectedCategoryDAO.getUserSelectedCategoriesByUsername(username);
    }

    @Override
    public List<UserSelectedCategory> getUserCompletedCategoriesByUsername(String username) {
        return userSelectedCategoryDAO.getUserCompletedCategoriesByUsername(username);
    }

    @Override
    public List<UserSelectedCategory> getUserUnfinishedCategoriesByUsername(String username) {
        return userSelectedCategoryDAO.getUserUnfinishedCategoriesByUsername(username);
    }

    @Override
    public UserSelectedCategory getSelectedCategoryByPK(UserSelectedCategoryPK pk) {
        return userSelectedCategoryDAO.getSelectedCategoryByPK(pk);
    }

    @Override
    public void saveOrUpdate(UserSelectedCategory userSelectedCategory) {
        userSelectedCategoryDAO.saveOrUpdate(userSelectedCategory);
    }
}
