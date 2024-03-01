package com.hcc.dtos;

// A DTO (Data Transfer Object) for the authentication credentials
// This class provides getters and setters for the username and password attributes
// This helps data transfer between the frontend and the backend
public class AuthCredentialRequest {
    private String username;
    private String password;

    public AuthCredentialRequest() {
    }

    public AuthCredentialRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
