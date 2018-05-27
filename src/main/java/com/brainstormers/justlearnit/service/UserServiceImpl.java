package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.UserDAO;
import com.brainstormers.justlearnit.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public User getUserById(String username) {
        return userDAO.getUserById(username);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

}


