package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.User;

public interface UserService {

    User getUserById(String username);

    void save(User user);

    void update(User user);
}
