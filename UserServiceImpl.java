package com.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.dao.UserDao;
import com.flightreservation.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(User user) {

        userDao.registerUser(user);

    }

    @Override
    public User login(String email, String password) {

        return userDao.login(email, password);

    }

}
