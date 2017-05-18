package com.babyElephant.server;


import com.babyElephant.po.User;


public interface UserServer {
    int getUser(User user);

    int saveUser(User user);
}
