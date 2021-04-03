package com.kleist.sportsportal.services;

import lombok.val;
import org.apache.commons.codec.binary.Hex;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SecutityService implements  ISecutityService{
    @Override
    public String endcodePassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
      val encoded =   messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        val encoder = Base64.getEncoder();
       return new String(Hex.encodeHex(encoded));
    }
}
