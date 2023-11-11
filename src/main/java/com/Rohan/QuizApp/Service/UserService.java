package com.Rohan.QuizApp.Service;

import java.util.List;

import com.Rohan.QuizApp.Dao.UserDao;
import com.Rohan.QuizApp.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

	public List<User> getAllUsers() {
		return userDao.findAll();
	}
    
}
