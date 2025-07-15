package com.project2025.auth_2.domain.DTO;

import com.project2025.auth_2.domain.Role;

public record RegisterDTO(String login, String password, Role role){
}
