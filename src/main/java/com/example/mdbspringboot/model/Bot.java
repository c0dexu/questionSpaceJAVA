package com.example.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bot")
public class Bot {
    @Id
    private String Id;

    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getId(){
        return this.Id;
    }
}
