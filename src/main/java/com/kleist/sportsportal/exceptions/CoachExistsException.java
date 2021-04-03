package com.kleist.sportsportal.exceptions;

public class CoachExistsException extends  Exception{

    public CoachExistsException(){
        super();
    }

    public CoachExistsException(String  message){
        super(message);
    }

    public CoachExistsException(String message , Throwable throwable) {
        super(message, throwable);
    }
}



