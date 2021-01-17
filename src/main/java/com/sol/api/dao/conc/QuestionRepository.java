package com.sol.api.dao.conc;

import org.springframework.stereotype.Service;

import com.sol.api.dao.intfc.Repository;
import com.sol.api.model.Question;

@Service
public class QuestionRepository extends Repository<Question, Long> {
}
