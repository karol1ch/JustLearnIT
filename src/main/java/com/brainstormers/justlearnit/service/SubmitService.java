package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Submit;

public interface SubmitService {

    Submit getSubmitByID(int id);

    void saveOrUpdate(Submit submit);

}
