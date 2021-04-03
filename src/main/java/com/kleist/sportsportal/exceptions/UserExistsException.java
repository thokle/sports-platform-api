package com.kleist.sportsportal.exceptions;

public class UserExistsException extends  Exception{


    public UserExistsException(){
        super();
    }

    public UserExistsException(String  message){
        super(message);
    }

    public UserExistsException(String message , Throwable throwable) {
        super(message, throwable);
    }


}

