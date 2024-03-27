package com.aledma.springsecurity.controller;

import com.aledma.springsecurity.dto.LoginRequestDto;
import com.aledma.springsecurity.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@RestController

public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    private ResponseEntity<String> getMemberProfile(
            @Valid @RequestBody LoginRequestDto requestDto
            ){
        String token = this.authService.login(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
