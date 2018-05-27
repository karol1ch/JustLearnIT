package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.UserDetail;

import java.util.List;


public interface UserDetailService {

    UserDetail getUserDetail(String username);

    void update(UserDetail userDetail);

    UserDetail getUserDetailByEmail(String email);

    void save(UserDetail userDetailByUsername);
}
