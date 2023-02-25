package com.example.questionSpace.controllers;

import com.example.mdbspringboot.model.Question;
import com.example.questionSpace.repositories.QuestionRepository;
import com.example.questionSpace.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/question")
    public ResponseEntity  addQuestion(@RequestBody String questionString){
        Question question = new Question(questionString);
        String[] answers = {"yes", "no", "three hundred people", "MANY DOGS!!", "i dont know"};
        int rnd = new Random().nextInt(answers.length);
        String ans = answers[rnd];
        question.setAnswer(ans);
        this.questionRepository.insert(question);
        return ResponseEntity.ok().body(question);

    }

    @GetMapping("/questions")
    public ResponseEntity  getQuestions(){
        List<Question> questions =  questionRepository.findAll();
        return ResponseEntity.ok().body(questions);
    }

    @DeleteMapping("questions/{id}")
    public @ResponseBody String deleteQuestion(@PathVariable String id){
        this.questionRepository.deleteById(id);
        return "deleted";
    }


}
