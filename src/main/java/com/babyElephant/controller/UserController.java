package com.babyElephant.controller;

import com.babyElephant.biz.UserBiz;
import com.babyElephant.util.ReturnMessage;
import com.babyElephant.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Matthew on 17/5/18.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/login")
    public @ResponseBody ReturnMessage login(UserVO userVO){
        return userBiz.login(userVO);
    }

    @RequestMapping("/save")
    public @ResponseBody ReturnMessage save(UserVO userVO){
        return userBiz.saveUser(userVO);
    }
}
