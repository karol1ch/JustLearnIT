package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.SubmitResult;

import java.util.List;

public interface SubmitResultDAO {

    List<SubmitResult> getSubmitResultsBySubmitID(int submitID);

    long getSubmitResultsAmountBySubmitID(int submitID);
}
