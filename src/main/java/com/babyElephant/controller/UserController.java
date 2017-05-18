package com.babyElephant.controller;

import com.babyElephant.biz.UserBiz;
import com.babyElephant.util.ReturnMessage;
import com.babyElephant.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by Matthew on 17/5/18.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/login")
    public @ResponseBody ReturnMessage login(HttpSession httpSession,UserVO userVO){
        ReturnMessage returnMessage= userBiz.login(userVO);
        if(returnMessage.getCode().equals("SUCCESS")){
            httpSession.setAttribute("LoginUser",userVO.getUserName());
        }
        return returnMessage;
    }

    @RequestMapping("/save")
    public @ResponseBody ReturnMessage save(UserVO userVO){
        return userBiz.saveUser(userVO);
    }

    @RequestMapping("/getLoginStatus")
    public @ResponseBody Object getLoginStatus(HttpSession httpSession){
        Object s=  httpSession.getAttribute("LoginUser");
        if (s!=null){
            return s;
        }else{
            return ReturnMessage.ERROR;
        }

    }

    @RequestMapping("/checkout")
    public @ResponseBody ReturnMessage checkout(HttpSession httpSession){
        httpSession.setAttribute("LoginUser",null);
        return ReturnMessage.SUCCESS;

    }





}
