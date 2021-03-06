package com.babyElephant.util;



public enum  ReturnMessage {

    SUCCESS("SUCCESS", "成功"),
    ERROR("ERROR","失败")
    ;
    private String code;

    private String message;

    private ReturnMessage(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}