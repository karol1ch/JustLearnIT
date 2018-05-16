package com.brainstormers.justlearnit.service;

import com.brainstormers.justlearnit.dao.ProgrammingLanguageDAO;
import com.brainstormers.justlearnit.models.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageServiceImpl implements ProgrammingLanguageService {

    @Autowired
    ProgrammingLanguageDAO programmingLanguageDAO;

    @Override
    public ProgrammingLanguage getProgrammingLangaugeByName(String name) {
        return programmingLanguageDAO.getProgrammingLangaugeByName(name);
    }

}
