package com.example.springbootpriject.CONTROLLER;

import com.example.springbootpriject.MODELS.Question;
import com.example.springbootpriject.MODELS.QuestionWrapper;
import com.example.springbootpriject.MODELS.Response;
import com.example.springbootpriject.SERVICE.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("quiz")
public class QuizController {

    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title ){

        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
       return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
     return quizService.calculateResult(id, responses);
    }
}
