package com.vidhyavistaar.night_watch.controller;

import com.vidhyavistaar.night_watch.service.JwtService;
import com.vidhyavistaar.night_watch.service.UserInfoService;
import com.vidhyavistaar.night_watch.entity.AuthRequest;
import com.vidhyavistaar.night_watch.entity.AuthResponse;
import com.vidhyavistaar.night_watch.entity.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserInfoService userInfoService;
    private final JwtService jwtService;

    public AuthController(UserInfoService userInfoService, JwtService jwtService) {
        this.userInfoService = userInfoService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        Optional<UserInfo> user = userInfoService.authenticateUser(username, password);

        if (user.isPresent()) {
            // Generate JWT token on successful authentication
            String jwtToken = jwtService.generateToken(username);
            return ResponseEntity.ok(new AuthResponse(jwtToken));
        } else {
            return ResponseEntity.status(401).body(new AuthResponse("Invalid credentials"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserInfo userInfo) {
        String response = userInfoService.saveUser(userInfo);
        return ResponseEntity.ok(response);
    }
}