package com.kisin.blog.service;

import com.kisin.blog.dao.UserDAO;
import com.kisin.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public boolean existsUsername(String username) {
        return userDAO.existsByUsername(username);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void save(User user) {
        userDAO.save(user);
    }
}
