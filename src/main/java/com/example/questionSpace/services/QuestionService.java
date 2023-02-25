package com.example.questionSpace.services;

import com.example.mdbspringboot.model.Answer;
import com.example.mdbspringboot.model.Question;
import com.example.questionSpace.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;


    public QuestionService(){}

    public void addQuestion(Question question){
        Answer answer = new Answer("bazinga");
        this.questionRepository.insert(question);
    }

    public List<Question> getQuestions(){
        return this.questionRepository.findAll();
    }

    public void deleteQuestion(String id){
        this.questionRepository.deleteById(id);
    }
}
