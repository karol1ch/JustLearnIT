package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.SubmitResultDAO;
import com.brainstormers.justlearnit.models.SubmitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitResultServiceImpl implements SubmitResultService {

    @Autowired
    SubmitResultDAO submitResultDAO;

    @Override
    public List<SubmitResult> getSubmitResultsBySubmitID(int submitID) {
        return submitResultDAO.getSubmitResultsBySubmitID(submitID);
    }

    @Override
    public long getSubmitResultsAmountBySubmitID(int submitID) {
        return submitResultDAO.getSubmitResultsAmountBySubmitID(submitID);
    }
}
