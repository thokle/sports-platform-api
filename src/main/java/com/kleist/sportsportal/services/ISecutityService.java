package com.kleist.sportsportal.services;

import java.security.NoSuchAlgorithmException;

public interface ISecutityService {

    public String endcodePassword(String password) throws NoSuchAlgorithmException;
}
