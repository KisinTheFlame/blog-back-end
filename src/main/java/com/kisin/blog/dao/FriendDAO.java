package com.kisin.blog.dao;

import com.kisin.blog.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendDAO extends JpaRepository<Friend, Integer> {

}
