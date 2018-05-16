package com.brainstormers.justlearnit.service;


import com.brainstormers.justlearnit.dao.ProblemDAO;
import com.brainstormers.justlearnit.models.Category;
import com.brainstormers.justlearnit.models.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService{

    @Autowired
    ProblemDAO problemDAO;


    public Problem getProblemById(int theId){
      return  problemDAO.getProblemById(theId);
    }

    public List<Problem> getProblemsList() {
        return problemDAO.getProblemsList();
    }


    public void deleteProblem(int problemId) {
        problemDAO.deleteProblem(problemId);
    }


    public void saveOrUpdate(Problem problem) {
        problemDAO.saveOrUpdate(problem);
    }


    public List<Problem> getProblemsWhereCategory(Category category) {
        return problemDAO.getProblemsWhereCategory(category);
    }


}
