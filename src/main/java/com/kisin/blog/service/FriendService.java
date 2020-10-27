package com.kisin.blog.service;

import com.kisin.blog.dao.FriendDAO;
import com.kisin.blog.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    @Autowired
    private FriendDAO friendDAO;

    public List<Friend> getAllFriends() {
        return friendDAO.findAll();
    }
}
