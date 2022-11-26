package com.example.gymapp.Repositories;

import com.example.gymapp.Entities.Trainee;
import com.example.gymapp.Entities.Trainer;
import com.example.gymapp.Entities.User;
import com.example.gymapp.Mappers.TraineeMapper;
import com.example.gymapp.Mappers.TrainerMapper;
import com.example.gymapp.Mappers.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


@Repository
public class UsersRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User getUserById(int id) {
        String query = "SELECT * FROM Users WHERE UserId = ?";
        User u = jdbcTemplate.queryForObject(query, new UserMapper(), id);
        return u;
    }

    public User getUserByEmail(final String email) {
        String query = "SELECT * FROM Users WHERE Email = ?";
        User u = jdbcTemplate.queryForObject(query, new UserMapper(), email);
        return u;
    }

    public Trainee getTraineeById(int id) {
        String query = "SELECT U.*, T.* FROM Trainees AS T LEFT JOIN USERS AS U "
            .concat("ON U.UserId=T.UserId WHERE U.UserId = ?");
        Trainee t = jdbcTemplate.queryForObject(query, new TraineeMapper(), id);
        return t;
    }

    public Trainee getTraineeByEmail(final String email) {
        String query = "SELECT U.*, T.* FROM Trainees AS T LEFT JOIN USERS AS U "
            .concat("ON U.UserId=T.UserId WHERE U.Email = ?");
        Trainee t = jdbcTemplate.queryForObject(query, new TraineeMapper(), email);
        return t;
    }

    public Trainer getTrainerById(int id) {
        String query = "SELECT U.*, T.* FROM Trainers AS T LEFT JOIN USERS AS U "
        .concat("ON U.UserId=T.UserId WHERE U.UserId = ?");
        Trainer t = jdbcTemplate.queryForObject(query, new TrainerMapper(), id);
        return t;
    }
}
