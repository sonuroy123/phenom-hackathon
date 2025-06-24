package com.phenom.flat_mate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.phenom.flat_mate.dto.LoginRequestDTO;
import com.phenom.flat_mate.dto.LoginResponseDTO;
import com.phenom.flat_mate.dto.SignupResponseDTO;
import com.phenom.flat_mate.dto.SignupRequestDTO;

public class AuthenticationController {
    
    @PostMapping("/login")
    public ResponseEntity<SignupResponseDTO> signUp(SignupRequestDTO signupRequestDTO) {
        throw new RuntimeException("");
    }

    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDTO) {

        throw new RuntimeException("");
    }
}
