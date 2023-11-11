package com.Rohan.QuizApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Locale.Category;

import com.Rohan.QuizApp.Dao.QuestionDao;
import com.Rohan.QuizApp.Dao.QuizDao;
import com.Rohan.QuizApp.Model.Question;
import com.Rohan.QuizApp.Model.QuestionWrapper;
import com.Rohan.QuizApp.Model.Quiz;
import com.Rohan.QuizApp.Model.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    QuizDao  quizDao;

    @Autowired
    QuestionDao questionDao;//question are comming from questiondeo

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);//with the help of lombok there is a getter setter
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success",HttpStatus.CREATED);

	}

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz= quizDao.findById(id);//data might come or not that why we use optional
       List<Question> questionsFromDB = quiz.get().getQuestions();
       List<QuestionWrapper> questionsForUser = new ArrayList<>();

       for(Question q:questionsFromDB)
       {
           QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
           questionsForUser.add(qw);
       }

       return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();

        List<Question> questions =quiz.getQuestions();
     int right=0;
     int i=0;
        for(Response response :responses)
        {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
            {
                right++;
            }
            i++;
        }

        return new ResponseEntity<>(right,HttpStatus.OK);
    }

    
    
}
