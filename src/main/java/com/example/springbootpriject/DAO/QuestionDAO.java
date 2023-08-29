package com.example.springbootpriject.DAO;
import com.example.springbootpriject.MODELS.Question;
import org.hibernate.query.spi.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//the table name and datatype of pry key is put in angle brackets
public  interface QuestionDAO extends JpaRepository<Question,Integer> {
    List<Question>findByCategory(String category);

    @Query(value ="SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)

    List<Question> findRandomQuestionsByCategory(String category,int numQ);

}

