package com.brainstormers.justlearnit.dao;

import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;

import java.util.List;

public interface ProblemDAO {

    public Problem getProblemById(int theId);

    public List<Problem> getProblemsList();


    public void deleteProblem(int problemId);

    void saveOrUpdate(Problem problem);

    List<Problem> getProblemsWhereCategory(Category category);

    List<Problem> getPracticeProblemsWhereCategory(Category category);
}
