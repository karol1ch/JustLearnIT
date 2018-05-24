package com.brainstormers.justlearnit.dao;


import com.brainstormers.justlearnit.models.User;

public interface UserDAO {

    User getUserById(String username);

    void update(User user);


    void save(User user);
}
