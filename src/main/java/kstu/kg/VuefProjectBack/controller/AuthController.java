package kstu.kg.VuefProjectBack.controller;

import io.swagger.annotations.ApiOperation;

import kstu.kg.VuefProjectBack.dto.request.UserAuthDtoRequest;
import kstu.kg.VuefProjectBack.dto.resoinse.UserAuthDtoResponse;
import kstu.kg.VuefProjectBack.service.AuthService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {
    final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("sign-up")
    @ApiOperation("API для регистрации на портале")
    public ResponseEntity<UserAuthDtoResponse> signUp(@Valid @RequestBody UserAuthDtoRequest userAuthDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.signUp(userAuthDtoRequest));
    }

    @PostMapping("sign-in")
    @ApiOperation("API для авторизации на портале")
    public ResponseEntity<UserAuthDtoResponse> signIn(@Valid @RequestBody UserAuthDtoRequest userAuthDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.signIn(userAuthDtoRequest));
    }
}
