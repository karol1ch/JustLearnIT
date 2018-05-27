package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;

import java.util.List;

public interface ProblemService {


    Problem getProblemById(int theId);

    List<Problem> getProblemsList();

    void deleteProblem(int problemId);

    void saveOrUpdate(Problem problem);

    List<Problem> getProblemsWhereCategory(Category category);

    List<Problem> getPracticeProblemsWhereCategory(Category category);
}
