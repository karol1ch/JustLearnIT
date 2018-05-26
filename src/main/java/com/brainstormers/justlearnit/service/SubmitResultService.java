package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.SubmitResult;

import java.util.List;

public interface SubmitResultService {

    List<SubmitResult> getSubmitResultsBySubmitID(int submitID);

    long getSubmitResultsAmountBySubmitID(int submitID);
}
