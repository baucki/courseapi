package com.example.courseapi.service;

import com.example.courseapi.exception.UserNotFoundException;
import com.example.courseapi.model.User;
import com.example.courseapi.repository.UserRepository;
import com.example.courseapi.utils.HashHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with the username: " + username + " was not found" ));
    }
    public boolean addUser(User requestUser) {
        User user = this.userRepository.findUserByUsername(requestUser.getUsername())
                .orElse(null);
        if (user == null) {
            requestUser.setPassword(HashHandler.sha256(requestUser.getPassword()));
            this.userRepository.save(requestUser);
            return true;
        }
        return false;
    }
    public boolean login(User requestUser) {
        User user = this.userRepository.findUserByUsername(requestUser.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User with the username: " + requestUser.getUsername() + " was not found" ));
        String requestPassword = HashHandler.sha256(requestUser.getPassword());
        return requestPassword != null && requestPassword.equals(user.getPassword());
    }
}
