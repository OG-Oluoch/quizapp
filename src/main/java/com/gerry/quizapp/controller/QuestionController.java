package com.gerry.quizapp.controller;

import com.gerry.quizapp.model.Question;
import com.gerry.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity <List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionCategory (@PathVariable String category){

        return questionService.getQuestionByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String>  addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);

    }
}
