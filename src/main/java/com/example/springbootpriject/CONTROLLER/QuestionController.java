package com.example.springbootpriject.CONTROLLER;


import com.example.springbootpriject.MODELS.Question;
import com.example.springbootpriject.SERVICE.QuestionService;
;import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//using it cause this is where we want to accept request
@RestController
@RequiredArgsConstructor
@RequestMapping("question")
public class QuestionController {

    //declare questionService to make us make ref to it

    QuestionService questionService;

    //this maps http reguest for allQuestions to this mthd
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        //this returns data from the service layer
        return questionService.getAllQuestions();
    }


    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
     // questionService.addQuestion(question);
      return questionService.addQuestion(question);
    }





}
