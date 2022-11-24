package com.example.gymapp.Repositories;

import com.example.gymapp.Entities.User;
import com.example.gymapp.Mappers.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User getUserById(int Id) {
        String query = "SELECT * FROM Users WHERE UserId = ?";
        User u = jdbcTemplate.queryForObject(query, new UserMapper(), Id);
        return u;
    }

    public User getUserByEmail(final String email) {
        String query = "SELECT * FROM Users WHERE Email = ?";
        User u = jdbcTemplate.queryForObject(query, new UserMapper(), email);
        return u;
    }
}
