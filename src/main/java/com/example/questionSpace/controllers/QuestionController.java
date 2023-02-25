package com.example.questionSpace.controllers;

import com.example.mdbspringboot.model.Bot;
import com.example.mdbspringboot.model.Question;
import com.example.questionSpace.repositories.BotRepository;
import com.example.questionSpace.repositories.QuestionRepository;
import com.example.questionSpace.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private BotRepository botRepository;

    @PostMapping("/question")
    public ResponseEntity  addQuestion(@RequestBody String questionString){
        Question question = new Question(questionString);
        List<Bot> words = this.botRepository.findAll();
        boolean found = false;
        for(Bot word: words){
            if(Objects.equals(word.getWord(), questionString)){
                found = true;
                break;
            }
        }

        if(!found){
            Bot bot = new Bot();
            bot.setWord(questionString);
            botRepository.insert(bot);
        }
        List<Bot> updatedWords = this.botRepository.findAll();

        int rand = new Random().nextInt(updatedWords.size());


        if(words.size() > 0){
            question.setAnswer(words.get(rand).getWord());
        }
        this.questionRepository.insert(question);
        return ResponseEntity.ok().body(question);

    }

    @GetMapping("/questions")
    public ResponseEntity  getQuestions(){
        List<Question> questions =  questionRepository.findAll();
        return ResponseEntity.ok().body(questions);
    }



    @DeleteMapping("questions/{id}")
    public ResponseEntity deleteQuestion(@PathVariable String id){
            this.questionRepository.deleteById(id);
        return ResponseEntity.ok().body(id);

    }


}
