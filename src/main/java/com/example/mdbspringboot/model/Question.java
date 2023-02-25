package com.example.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "questions")
public class Question {
    @Id
    private String Id;
    private String question;
    private Date questionTimestamp;
    private String answer;

    public Question(String question){
        this.question = question;
        this.questionTimestamp = new Date();
    }

    public String getId(){
        return this.Id;
    }

    public String getQuestion(){
        return this.question;
    }

    public String getAnswer(){
        return this.answer;
    }

    public Date getQuestionTimestamp(){
        return this.questionTimestamp;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }




}
