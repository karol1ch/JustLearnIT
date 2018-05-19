package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.UserDetailDAO;
import com.brainstormers.justlearnit.models.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    UserDetailDAO userDetailDAO;

    @Override
    @Transactional
    public UserDetail getUserDetail(String username) {
        return userDetailDAO.getUserDetail(username);
    }

    @Override
    @Transactional
    public void update(UserDetail userDetail) {
        userDetailDAO.update(userDetail);
    }

    @Override
    @Transactional
    public UserDetail getUserDetailByEmail(String email) {
        return userDetailDAO.getUserDetailByEmail(email);
    }


}
