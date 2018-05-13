package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Submit;

public interface SubmitDAO {

    Submit getSubmitByID(int id);

    void saveOrUpdate(Submit submit);

}
