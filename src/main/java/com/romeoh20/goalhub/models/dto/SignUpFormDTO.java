package com.romeoh20.goalhub.models.dto;

public class SignUpFormDTO extends LoginFormDTO {

    public String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
