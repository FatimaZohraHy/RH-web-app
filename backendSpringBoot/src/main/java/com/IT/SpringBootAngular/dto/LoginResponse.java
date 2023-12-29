package com.IT.SpringBootAngular.dto;

public class LoginResponse {
    private String jwToken;

    public LoginResponse(String jwToken) {
        this.jwToken = jwToken;
    }

    public String getJwToken() {
        return jwToken;
    }

    public void setJwToken(String jwToken) {
        this.jwToken = jwToken;
    }
}
