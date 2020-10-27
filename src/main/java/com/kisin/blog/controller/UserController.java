package com.kisin.blog.controller;

import com.kisin.blog.pojo.User;
import com.kisin.blog.result.Result;
import com.kisin.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import static com.kisin.blog.result.ResultCode.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {

        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        if (username.equals("")) return new Result(USERNAME_IS_MISSING);
        username = HtmlUtils.htmlEscape(username);

        if (requestUser.getPassword().equals("")) return new Result(PASSWORD_IS_MISSING);

        User user = userService.existsUsername(username) ? userService.findByUsername(username) : null;
        if (user == null) return new Result(USER_NOT_EXIST);
        if (!user.getPassword().equals(requestUser.getPassword())) return new Result(PASSWORD_NOT_CORRECT);
        return new Result(SUCCESS);
    }
}
