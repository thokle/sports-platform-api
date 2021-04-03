package com.kleist.sportsportal.exceptions;

public class ActivityExistException extends   Exception{

    public ActivityExistException(){
        super();
    }

    public ActivityExistException(String  message){
        super(message);
    }

    public ActivityExistException(String message , Throwable throwable) {
        super(message, throwable);
    }
}
