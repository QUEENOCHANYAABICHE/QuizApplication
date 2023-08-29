package com.example.springbootpriject.DAO;

import com.example.springbootpriject.MODELS.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {

}

