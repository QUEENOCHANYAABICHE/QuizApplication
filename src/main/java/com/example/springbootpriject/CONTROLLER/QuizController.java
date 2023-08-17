package com.example.springbootpriject.CONTROLLER;

import com.example.springbootpriject.MODELS.Question;
import com.example.springbootpriject.MODELS.QuestionWrapper;
import com.example.springbootpriject.SERVICE.QuizService;
import jakarta.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController
 {
     @Autowired
     QuizService quizService;

    @PostMapping("create")
   public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
         return quizService.createQuiz(category, numQ,title);
   }

    @GetMapping("get/id")
     public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
         return quizService.getQuizQuestions(id);
    }

    // public ResponseEntity<Integer> calculateResult(Integer id, List<com.example.springbootpriject.MODELS.Response> responses){

         @PostMapping("submit/{id}")
     public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){

             return quizService.calculateResult(id, responses);
         }

}
