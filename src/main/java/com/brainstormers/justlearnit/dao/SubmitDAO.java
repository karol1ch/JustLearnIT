package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Submit;

import java.util.List;

public interface SubmitDAO {

    Submit getSubmitByID(int id);

    Submit getSubmitByIDAndUsername(int id, String username);

    void saveOrUpdate(Submit submit);

    List<Submit> getSubmitByUsername(String username);
}
