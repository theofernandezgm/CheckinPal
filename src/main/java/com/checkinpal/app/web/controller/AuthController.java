// src/main/java/com/yourcompany/app/web/controller/AuthController.java
package com.checkinpal.app.web.controller;

import com.checkinpal.app.service.AuthService;
import com.checkinpal.app.web.dto.SignupRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") // All endpoints in this class will start with /auth
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup") // Responds to POST requests at /auth/signup
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody SignupRequest signupRequest) {
        authService.registerOwner(
                signupRequest.email(),
                signupRequest.password(),
                signupRequest.legalName(),
                signupRequest.nif()
        );
    }
}