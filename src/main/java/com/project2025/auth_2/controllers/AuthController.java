package com.project2025.auth_2.controllers;

import com.project2025.auth_2.domain.DTO.LoginDTO;
import com.project2025.auth_2.domain.DTO.LoginResponseDTO;
import com.project2025.auth_2.domain.DTO.RegisterDTO;
import com.project2025.auth_2.domain.User;
import com.project2025.auth_2.repositories.UserRepository;
import com.project2025.auth_2.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterDTO dto) {
        User user = new User(null,
                dto.login(),
                new BCryptPasswordEncoder().encode(dto.password()),
                dto.role());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> LOGIN(@RequestBody LoginDTO dto) {
        var auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.login(), dto.password()));
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));

    }
}
