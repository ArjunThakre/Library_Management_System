package com.example.lobrarymanagement.DTO;

import java.util.Set;
import java.util.Objects;

public class LoginResponseDTO {
    private String token;
    private String username;
    private Set<String> roles;

    // All-args constructor (used by Builder)
    public LoginResponseDTO(String token, String username, Set<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    // No-args constructor (if needed)
    public LoginResponseDTO() {}

    // Getters
    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    // Setters
    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    // toString()
    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginResponseDTO that = (LoginResponseDTO) o;
        return Objects.equals(token, that.token) &&
                Objects.equals(username, that.username) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, username, roles);
    }

    // Builder Pattern
    public static LoginResponseDTOBuilder builder() {
        return new LoginResponseDTOBuilder();
    }

    public static class LoginResponseDTOBuilder {
        private String token;
        private String username;
        private Set<String> roles;

        public LoginResponseDTOBuilder token(String token) {
            this.token = token;
            return this;
        }

        public LoginResponseDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginResponseDTOBuilder roles(Set<String> roles) {
            this.roles = roles;
            return this;
        }

        public LoginResponseDTO build() {
            return new LoginResponseDTO(token, username, roles);
        }
    }
}