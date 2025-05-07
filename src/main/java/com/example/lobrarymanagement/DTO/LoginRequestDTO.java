package com.example.lobrarymanagement.DTO;

public class LoginRequestDTO {
    private String username;
    private String password;

    // Constructor for Builder
    private LoginRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Builder
    public static LoginRequestDTOBuilder builder() {
        return new LoginRequestDTOBuilder();
    }

    public static class LoginRequestDTOBuilder {
        private String username;
        private String password;

        public LoginRequestDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginRequestDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public LoginRequestDTO build() {
            return new LoginRequestDTO(username, password);
        }
    }
}