package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Problem;

import javax.transaction.Transactional;
import java.util.List;

public interface ProblemService {


    public Problem getProblemById(int theId);

    public List<Problem> getProblemsList();


    public void deleteProblem(int problemId);

    void saveOrUpdate(Problem problem);
}
