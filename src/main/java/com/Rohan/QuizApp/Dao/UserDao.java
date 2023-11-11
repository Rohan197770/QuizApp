package com.Rohan.QuizApp.Dao;

import com.Rohan.QuizApp.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
    
}
