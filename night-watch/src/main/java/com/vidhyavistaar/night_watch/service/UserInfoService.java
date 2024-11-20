package com.vidhyavistaar.night_watch.service;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vidhyavistaar.night_watch.entity.UserInfo;
import com.vidhyavistaar.night_watch.repository.UserInfoRepository;

@Service
public class UserInfoService{
    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;

    UserInfoService(PasswordEncoder passwordEncoder, UserInfoRepository userInfoRepository){
        this.passwordEncoder = passwordEncoder;
        this.userInfoRepository = userInfoRepository;
    }

    public String saveUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User saved successfully!";
    }

    public Optional<UserInfo> authenticateUser(String username, String password) {
        Optional<UserInfo> user = userInfoRepository.findByName(username);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user; // Return user if credentials are valid
        }
        return Optional.empty(); // Return empty if authentication fails
    }
}