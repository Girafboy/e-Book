package com.example.girafboy.repository;

import com.example.girafboy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Query
    User findUserByUserIDAndPassword(String id, String password);
}
