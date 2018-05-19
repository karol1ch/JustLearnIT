package com.brainstormers.justlearnit.dao;


import com.brainstormers.justlearnit.models.User;

import java.util.List;

public interface UserDAO {

    User getUserById(String username);

    void update(User user);

}
