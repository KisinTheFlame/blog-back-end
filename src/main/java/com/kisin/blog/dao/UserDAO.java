package com.kisin.blog.dao;

import com.kisin.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);
}
