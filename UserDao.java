package com.flightreservation.dao;

import com.flightreservation.model.User;

public interface UserDao {

    void registerUser(User user);

    User login(String email, String password);

}
