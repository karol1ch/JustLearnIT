package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.SubmitDAO;
import com.brainstormers.justlearnit.models.Submit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmitServiceImpl implements SubmitService {

    @Autowired
    SubmitDAO submitDAO;

    @Override
    public Submit getSubmitByID(int id) {
        return submitDAO.getSubmitByID(id);
    }

    @Override
    public void saveOrUpdate(Submit submit) {
        submitDAO.saveOrUpdate(submit);
    }
}
