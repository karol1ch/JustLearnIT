package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.TestDAO;
import com.brainstormers.justlearnit.models.Problem;
import com.brainstormers.justlearnit.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDAO testDAO;

    @Override
    public Test getTestByID(int id) {
        return testDAO.getTestByID(id);
    }

    @Override
    public Test getTestByProblemIDAndNumber(Problem problem, int number) {
        return testDAO.getTestByProblemIDAndNumber(problem, number);
    }

    @Override
    public List<Test> getTestsByProblemID(Problem problem) {
        return testDAO.getTestsByProblemID(problem);
    }

    @Override
    public Test getOpenTestByProblemID(Problem problem) {
        return testDAO.getOpenTestByProblemID(problem);
    }
}
