package com.babyElephant.biz.impl;

import com.babyElephant.biz.UserBiz;
import com.babyElephant.po.User;
import com.babyElephant.server.UserServer;
import com.babyElephant.util.CreateMD5;
import com.babyElephant.util.ReturnMessage;
import com.babyElephant.util.StringUtil;
import com.babyElephant.util.UUIDUtil;
import com.babyElephant.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Matthew on 17/5/18.
 */
@Service
public class UserBizImpl implements UserBiz{

    @Autowired
    private UserServer userServer;


    public ReturnMessage login(UserVO userVO) {

        User user =new User();
        user.setUserName(userVO.getUserName());
        user.setPassword(CreateMD5.getMd5(userVO.getPassword()));
        int i=userServer.getUser(user);

        if (i>0){
          return ReturnMessage.SUCCESS;
        }else{
            return  ReturnMessage.ERROR;
        }
    }

    public ReturnMessage saveUser(UserVO userVO) {
        if (StringUtils.isEmpty(userVO.getUserName())){
            return  ReturnMessage.ERROR;
        }
        if (StringUtils.isEmpty(userVO.getPassword())){
            return  ReturnMessage.ERROR;
        }
        if (!userVO.getPassword().equals(userVO.getPassword_confirmation())){
            return  ReturnMessage.ERROR;
        }
        User user =new User();
        user.setUuid(UUIDUtil.getUUID());
        user.setUserName(userVO.getUserName());
        user.setPassword(CreateMD5.getMd5(userVO.getPassword()));
        int i=userServer.saveUser(user);

        if (i>0){
            return ReturnMessage.SUCCESS;
        }else{
            return  ReturnMessage.ERROR;
        }
    }
}
