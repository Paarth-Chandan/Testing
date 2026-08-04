package com.flightreservation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.flightreservation.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void registerUser(User user) {

        String sql = "INSERT INTO user(name,email,password,role) VALUES(?,?,?,?)";

        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole());

    }

    @Override
    public User login(String email, String password) {

        String sql = "SELECT * FROM user WHERE email=? AND password=?";

        try {

            return jdbcTemplate.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<>(User.class),
                    email,
                    password);

        } catch (Exception e) {

            return null;

        }

    }

}
