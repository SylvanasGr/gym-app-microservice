package com.example.gymapp.Repositories;

import com.example.gymapp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    
    @Query(value = "SELECT * FROM Users WHERE UserId = :Id", nativeQuery = true)
    Optional<User> getUserById(int Id);

    @Query(name = "SELECT * FROM Users WHERE Email = :email", nativeQuery = true)
    Optional<User> getUserByEmail(String email);
}
