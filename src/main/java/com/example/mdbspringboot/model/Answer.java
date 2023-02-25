package com.example.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "answers")
public class Answer {
    @Id
    private String Id;

    private String answer;

    public Answer(String answer) {
        this.answer = answer;
    }

}
