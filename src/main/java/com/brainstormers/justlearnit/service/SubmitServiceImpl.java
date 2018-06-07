package com.brainstormers.justlearnit.service;



import com.brainstormers.justlearnit.dao.SubmitDAO;
import com.brainstormers.justlearnit.dao.SubmitResultDAO;
import com.brainstormers.justlearnit.dao.TestDAO;
import com.brainstormers.justlearnit.models.Submit;
import com.brainstormers.justlearnit.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitServiceImpl implements SubmitService {

    @Autowired
    SubmitDAO submitDAO;

    @Autowired
    SubmitResultDAO submitResultDAO;

    @Autowired
    TestDAO testDAO;

    @Override
    public Submit getSubmitByID(int id) {
        return submitDAO.getSubmitByID(id);
    }


    @Override
    public Submit getSubmitByIDAndUsername(int id, String username) {
        return submitDAO.getSubmitByIDAndUsername(id, username);
    }

    @Override
    public List<Submit> getSubmitsByUsername(String username) {
        return submitDAO.getSubmitByUsername(username);
    }

    @Override
    public void saveOrUpdate(Submit submit) {
        submitDAO.saveOrUpdate(submit);
    }

    @Override
    public void waitForSubmitProcessing(Submit submit) {
        long testsAmount = testDAO.getAmountOfTestsByProblemID(submit.getProblem());

        while (submit.getCompilationReturnCode() == null ||
                submitResultDAO.getSubmitResultsAmountBySubmitID(submit.getId()) != testsAmount) {
            submit = submitDAO.getSubmitByID(submit.getId());

            if (submit.getCompilationReturnCode() != null && submit.getCompilationReturnCode().intValue() != 0) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
