package com.Rohan.QuizApp.Controller;

import java.util.List;

import com.Rohan.QuizApp.Model.Question;
import com.Rohan.QuizApp.Model.QuestionWrapper;
import com.Rohan.QuizApp.Model.Response;
import com.Rohan.QuizApp.Service.QuestionService;
import com.Rohan.QuizApp.Service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create") // to take input of string we use request param
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam  int numQ, @RequestParam String title )
    
    {
        // return  new ResponseEntity<>("I am here",HttpStatus.OK);//function return type should be same  
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id)
    {
         return  quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses)
    {
        return quizService.calculateResult(id,responses);
    }
    
    
}
