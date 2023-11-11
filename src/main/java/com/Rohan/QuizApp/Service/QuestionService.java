package com.Rohan.QuizApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Rohan.QuizApp.Dao.QuestionDao;
import com.Rohan.QuizApp.Model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    // public List<Question> getAllQuestions() {
    //     return questionDao.findAll();

    //     /*
    //     List<Question> questions = new ArrayList<Question>();

    //     Question question1 = new Question();
    //     question1.setId(1);
    //     question1.setQuestionTitle("Hello Question1");

    //     Question question2 = new Question();
    //     question2.setId(2);
    //     question2.setQuestionTitle("Hello Question1");

    //     questions.add(question1);
    //     questions.add(question2);
        
    //     return questions;

    //     */
    // }

    public ResponseEntity<List<Question>> getAllquestions()
    {
        try{
        return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();

        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);            }
            catch(Exception e){
                e.printStackTrace();
    
            }
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
            }

	public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return  new ResponseEntity<>("success",HttpStatus.CREATED);

	}

    public String updateAnswer(Integer id, String correct_ans) {
        if(correct_ans == null || correct_ans.isEmpty()) {
            return "answer not given";
        }
        Optional<Question> optionalQuestion = questionDao.findById(id);
        if(optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            question.setCorrectAns(correct_ans);
            questionDao.save(question);
            return "updated";
        } else {
            // Throw error
            return "Id not present";
        }
    }


    
}
