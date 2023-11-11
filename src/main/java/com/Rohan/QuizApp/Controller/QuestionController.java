package com.Rohan.QuizApp.Controller;

import java.util.List;

import com.Rohan.QuizApp.Model.Question;
import com.Rohan.QuizApp.Service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    // @GetMapping("allQuestions")
    // public List<Question> getAllQuestions()
    // {
    //     return questionService.getAllQuestions();
    // }

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        // return new ResponseEntity<>(questionService.getAllQuestions(),HttpStatus.OK);
        return questionService.getAllquestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
        
    }

    @PutMapping("/{questionId}")
    public  String updateAnswer(@PathVariable Integer questionId,
        @RequestParam(value = "correct_ans", required = false) String correct_ans)
    {
        return questionService.updateAnswer(questionId,correct_ans);
    }
    
    
   
}
