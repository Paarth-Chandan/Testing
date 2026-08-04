package com.flightreservation.service;

import com.flightreservation.model.User;

public interface UserService {

    void registerUser(User user);

    User login(String email, String password);

}
