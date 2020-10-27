package com.kisin.blog.controller;

import com.kisin.blog.result.Result;
import com.kisin.blog.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.kisin.blog.result.ResultCode.*;

@Controller
public class FriendController {
    @Autowired
    private FriendService friendService;

    @CrossOrigin
    @GetMapping(value = "api/friend-list")
    @ResponseBody
    public Result getAllFriends() throws Exception {
        return new Result(SUCCESS, friendService.getAllFriends());
    }
}
