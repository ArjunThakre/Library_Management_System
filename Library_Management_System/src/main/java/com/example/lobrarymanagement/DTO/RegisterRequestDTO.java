package com.example.lobrarymanagement.DTO;

import java.util.Objects;

public class RegisterRequestDTO {
    private String username;
    private String email;
    private String password;

    // Constructor for Builder
    public RegisterRequestDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // No-args constructor (if needed)
    public RegisterRequestDTO() {}

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString()
    @Override
    public String toString() {
        return "RegisterRequestDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterRequestDTO that = (RegisterRequestDTO) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password);
    }

    // Builder Pattern
    public static RegisterRequestDTOBuilder builder() {
        return new RegisterRequestDTOBuilder();
    }

    public static class RegisterRequestDTOBuilder {
        private String username;
        private String email;
        private String password;

        public RegisterRequestDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public RegisterRequestDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public RegisterRequestDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public RegisterRequestDTO build() {
            return new RegisterRequestDTO(username, email, password);
        }
    }
}