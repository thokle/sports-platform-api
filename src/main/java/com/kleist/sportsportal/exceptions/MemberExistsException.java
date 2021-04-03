package com.kleist.sportsportal.exceptions;

public class MemberExistsException extends  Exception{


    public MemberExistsException(){
        super();
    }

    public MemberExistsException(String  message){
        super(message);
    }

    public MemberExistsException(String message , Throwable throwable) {
        super(message, throwable);
    }

}
