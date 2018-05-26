package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.models.Test;

import java.util.List;

public interface TestDAO {

    Test getTestByID(int id);

    Test getTestByProblemIDAndNumber(Problem problemID, int number);

    List<Test> getTestsByProblemID(Problem problem);

    Test getOpenTestByProblemID(Problem problem);

    long getAmountOfTestsByProblemID(Problem problem);
}
