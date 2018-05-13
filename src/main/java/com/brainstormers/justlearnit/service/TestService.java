package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.models.Test;

import java.util.List;

public interface TestService {

    Test getTestByID(int id);

    Test getTestByProblemIDAndNumber(Problem problem, int number);

    List<Test> getTestsByProblemID(Problem problem);

    Test getOpenTestByProblemID(Problem problem);

}
