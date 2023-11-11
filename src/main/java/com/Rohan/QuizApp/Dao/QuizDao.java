package com.Rohan.QuizApp.Dao;

import com.Rohan.QuizApp.Model.Quiz;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao  extends JpaRepository<Quiz,Integer>
{

    
    
}
