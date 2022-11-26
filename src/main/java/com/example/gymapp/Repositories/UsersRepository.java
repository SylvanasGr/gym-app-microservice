package com.example.gymapp.Repositories;

import com.example.gymapp.Entities.Trainee;
import com.example.gymapp.Entities.Trainer;
import com.example.gymapp.Entities.User;
import com.example.gymapp.Mappers.TraineeMapper;
import com.example.gymapp.Mappers.TrainerMapper;
import com.example.gymapp.Mappers.UserMapper;

import java.util.List;

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
        Trainee t = jdbcTemplate.queryForObject(
            getByIdQuery("Trainees"), new TraineeMapper(), id
            );
        return t;
    }

    public Trainee getTraineeByEmail(final String email) {
        Trainee t = jdbcTemplate.queryForObject(
            getByEmailQuery("Trainees"), new TraineeMapper(), email
            );
        return t;
    }

    public List<Trainee> getTrainees() {
        String query = "SELECT U.*, T.* FROM Trainees AS T LEFT JOIN USERS AS U ON U.UserId=T.UserId";
        List<Trainee> t = jdbcTemplate.query(query, new TraineeMapper());
        return t;
    }

    public Trainer getTrainerById(int id) {
        Trainer t = jdbcTemplate.queryForObject(
            getByIdQuery("Trainers"), new TrainerMapper(), id
            );
        return t;
    }

    public Trainer getTrainerByEmail(final String email) {
        Trainer t = jdbcTemplate.queryForObject(
            getByEmailQuery("Trainers"), new TrainerMapper(), email
            );
        return t;
    }


    public List<Trainer> getTrainers() {
        String query = "SELECT U.*, T.* FROM Trainers AS T LEFT JOIN USERS AS U ON U.UserId=T.UserId";
        List<Trainer> t = jdbcTemplate.query(query, new TrainerMapper());
        return t;
    }

    private String getByIdQuery(String table) {
        return "SELECT U.*, T.* FROM " + table + " AS T LEFT JOIN USERS AS U "
        .concat("ON U.UserId=T.UserId WHERE U.UserId = ?");
    }

    private String getByEmailQuery(String table) {
        return "SELECT U.*, T.* FROM " + table + " AS T LEFT JOIN USERS AS U "
        .concat("ON U.UserId=T.UserId WHERE U.Email = ?");
    }

}
