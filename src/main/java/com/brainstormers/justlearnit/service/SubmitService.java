package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Submit;

import java.util.List;

public interface SubmitService {

    Submit getSubmitByID(int id);

    Submit getSubmitByIDAndUsername(int id, String username);

    List<Submit> getSubmitsByUsername(String username);

    void saveOrUpdate(Submit submit);

    void waitForSubmitProcessing(Submit submit);
}
