package com.brainstormers.justlearnit.service;


import com.brainstormers.justlearnit.dao.ProblemDAO;
import com.brainstormers.justlearnit.dao.ProblemDAOImpl;
import com.brainstormers.justlearnit.models.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService{

    @Autowired
    ProblemDAO problemDAO;

    @Transactional
    public Problem getProblemById(int theId){
      return  problemDAO.getProblemById(theId);
    }

    public List<Problem> getProblemsList() {
        return problemDAO.getProblemsList();
    }


    public void deleteProblem(int problemId) {
        problemDAO.deleteProblem(problemId);
    }

    @Override
    public void saveOrUpdate(Problem problem) {
        problemDAO.saveOrUpdate(problem);
    }
}
