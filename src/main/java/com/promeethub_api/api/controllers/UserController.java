package com.promeethub_api.api.controllers;

import com.promeethub_api.api.models.dtos.AuthDTO;
import com.promeethub_api.api.models.form.LoginForm;
import com.promeethub_api.api.models.form.RegisterForm;
import com.promeethub_api.businessLayer.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AuthService authService;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<AuthDTO> register(@RequestBody @Valid RegisterForm form) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(form.toEntity()));
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestBody @Valid LoginForm form) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(form.toEntity()));
    }
}
