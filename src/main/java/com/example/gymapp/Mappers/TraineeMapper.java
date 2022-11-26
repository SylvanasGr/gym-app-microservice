package com.example.gymapp.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.gymapp.Entities.Trainee;

public class TraineeMapper implements RowMapper<Trainee> {

    @Override
    public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trainee t = new Trainee(new UserMapper().mapRow(rs, rowNum));
        t.setWeight(rs.getFloat("weight"));
        t.setHeight(rs.getFloat("height"));
        t.setInjuries(rs.getString("injuries"));
        return t;
    }
    
}
