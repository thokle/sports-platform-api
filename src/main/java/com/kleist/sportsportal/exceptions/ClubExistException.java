package com.kleist.sportsportal.exceptions;

public class ClubExistException extends  Exception{


    public ClubExistException(){
        super();
    }

    public ClubExistException(String  message){
        super(message);
    }

    public ClubExistException(String message , Throwable throwable) {
        super(message, throwable);
    }
}
