package com.example.springbootpriject.SERVICE;


import com.example.springbootpriject.DAO.QuestionDAO;
import com.example.springbootpriject.DAO.QuizDAO;
import com.example.springbootpriject.MODELS.Question;
import com.example.springbootpriject.MODELS.Response;

import com.example.springbootpriject.MODELS.QuestionWrapper;
import com.example.springbootpriject.MODELS.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class  QuizService {
    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;

 public ResponseEntity<String> createQuiz(String category, int numQ, String title){

List<Question> questions = (List<Question>) questionDAO.findRandomQuestionsByCategory(category, numQ);

     Quiz quiz = new Quiz();
      quiz.setTitle(title);
      quiz.setQuestions(questions);
      quizDAO.save(quiz);

      return new ResponseEntity<>("Success",HttpStatus.CREATED);
 }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz = quizDAO.findById(id);
       List<Question> questionsFromDB = quiz.get().getQuestions();
       List<QuestionWrapper> questionsForUser = new ArrayList<>();
       for(Question q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(), q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
       }
       return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
 }

 public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses){
     Quiz quiz = quizDAO.findById(id).get();
     List<Question> questions = quiz.getQuestions();
      int i=0;
      int right =0;
     for(Response response : responses){
         if(response.getResponse().equals(questions.get(i).getRightAnswer()))
             right++;
         i++;
      }
     return new ResponseEntity<>(right, HttpStatus.OK);
 }

}
