package com.romeoh20.goalhub.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User extends AbstractEntity {

    private String username;
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User (String username, String password){
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password,pwHash);
    }

    public String getUsername() {
        return username;
    }
}