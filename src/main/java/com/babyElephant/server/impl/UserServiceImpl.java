package com.babyElephant.server.impl;

import com.babyElephant.dao.UserDao;
import com.babyElephant.po.User;
import com.babyElephant.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserServer{

    @Autowired
    private UserDao userDao;


    public int getUser(User user) {
        return userDao.getUser(user);
    }

    public int saveUser(User user) {
        return userDao.saveUser(user);
    }
}
