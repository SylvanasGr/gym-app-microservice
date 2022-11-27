package com.example.gymapp.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.gymapp.Entities.jdbc.Trainer;
import com.example.gymapp.Enums.TrainerType;
import com.example.gymapp.Exceptions.GenericException;

public class TrainerMapper implements RowMapper<Trainer> {

    @Override
    public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trainer t = new Trainer(new UserMapper().mapRow(rs, rowNum));
        t.setTrainerType(mapTrainerType(rs.getInt("trainertypeid")));
        t.setBankAccount(rs.getString("bankaccount"));
        t.setProfileDescription(rs.getString("profiledescription"));
        return t;
    }
    
    private TrainerType mapTrainerType(int id) throws GenericException {
        if (id == 1) return TrainerType.GYM;
        else if (id == 2) return TrainerType.FREELANCER; 
        throw new GenericException("Unknown trainer type id: " + Integer.toString(id));
    }
}
