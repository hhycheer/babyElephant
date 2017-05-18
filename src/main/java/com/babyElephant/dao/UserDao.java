package com.babyElephant.dao;

import com.babyElephant.po.User;

public interface UserDao {

    int getUser(User user);

    int saveUser(User user);
}
