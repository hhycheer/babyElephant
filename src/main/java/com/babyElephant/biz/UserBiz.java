package com.babyElephant.biz;

import com.babyElephant.util.ReturnMessage;
import com.babyElephant.vo.UserVO;

/**
 * Created by Matthew on 17/5/18.
 */
public interface UserBiz {

    ReturnMessage login(UserVO userVO);

    ReturnMessage saveUser(UserVO userVO);
}
