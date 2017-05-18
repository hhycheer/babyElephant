package com.babyElephant.vo;

/**
 * Created by Matthew on 17/5/18.
 */
public class UserVO {

    private String userName;
    private String password;
    private String password_confirmation;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public UserVO() {
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;



    }


    public UserVO(String userName, String password, String password_confirmation) {
        this.userName = userName;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }
}
