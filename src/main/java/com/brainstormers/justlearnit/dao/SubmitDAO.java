package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Submit;

public interface SubmitDAO {

    Submit getSubmitByID(int id);

    Submit getSubmitByIDAndUsername(int id, String username);

    void saveOrUpdate(Submit submit);
}
