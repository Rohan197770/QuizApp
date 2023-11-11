package com.Rohan.QuizApp.Dao;

import java.util.List;

import com.Rohan.QuizApp.Model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao  extends JpaRepository<Question,Integer>{

   List<Question> findByCategory(String category);
                                                //we do this because we have indentify match the category
   @Query(value= "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery=true)
   List<Question> findRandomQuestionByCategory(String category, int numQ);
   // now we have write sql quesries but we write native queries
    
}
