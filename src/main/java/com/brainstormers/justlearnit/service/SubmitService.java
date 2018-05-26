package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Submit;

public interface SubmitService {

    Submit getSubmitByID(int id);

    Submit getSubmitByIDAndUsername(int id, String username);

    void saveOrUpdate(Submit submit);

}
