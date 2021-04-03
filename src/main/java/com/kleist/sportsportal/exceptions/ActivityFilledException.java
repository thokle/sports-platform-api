package com.kleist.sportsportal.exceptions;

public class ActivityFilledException extends Exception {

    public ActivityFilledException(){
        super();
    }

    public ActivityFilledException(String  message){
        super(message);
    }

    public ActivityFilledException(String message , Throwable throwable) {
        super(message, throwable);
    }
}
