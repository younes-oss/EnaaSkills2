package com.enaa.authservice.DTO;

import com.enaa.authservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AuthDTOs {

    @Data
    @NoArgsConstructor
    public static class RegisterRequest {
        private String email;
        private String password;
        private Role role;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }
    }

    @Data
    @NoArgsConstructor
    public static class LoginRequest {
        private String email;
        private String password;
    }

    @Data
    @AllArgsConstructor
    public static class AuthResponse {
        private String token;
    }
}

