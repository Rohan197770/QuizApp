package com.Rohan.QuizApp.Model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
@Entity// we need to create table thats why we written entity
@Data // we use lombok(data) to create getter and setter
public class Quiz {
    // we nee dprimary key,2 title, 3 questions
    //and we cannot everything in one table because one quixz have multiple table
    @Id // to make id  a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// because we have to automaticaaly increasee the value of id
    private Integer id;
    private String title;
    @ManyToMany
    private List<Question>  questions;
    
}
