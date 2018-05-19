package com.brainstormers.justlearnit.dao;


import com.brainstormers.justlearnit.models.UserDetail;

import java.util.List;

public interface UserDetailDAO {

    UserDetail getUserDetail(String username);

    void update(UserDetail userDetail);

    UserDetail getUserDetailByEmail(String email);

}
