package com.example.accauntigGus.repository;

import com.example.accauntigGus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByLogin(String login);
}