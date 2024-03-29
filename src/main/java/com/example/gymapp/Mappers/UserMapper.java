package com.example.gymapp.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.gymapp.Entities.jdbc.User;
import com.example.gymapp.Enums.Sex;
import com.example.gymapp.Exceptions.GenericException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User u = new User();
        u.setUserId(rs.getInt("userid"));
        u.setName(rs.getString("name"));
        u.setSurname(rs.getString("surname"));
        u.setSex(mapSex(rs.getString("sex")));
        u.setAge(rs.getInt("age"));
        u.setEmail(rs.getString("email"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setCountry(rs.getString("country"));
        u.setArea(rs.getString("area"));
        u.setPhoneNumber(rs.getString("phonenumber"));
        return u;
    }

    private Sex mapSex(String s) throws GenericException {
        if (s.equals("M")) return Sex.MALE;
        else if (s.equals("F")) return Sex.FEMALE;
        throw new GenericException("Unknown sex: " + s);
    }
}
