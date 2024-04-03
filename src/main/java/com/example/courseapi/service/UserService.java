package com.example.courseapi.service;

import com.example.courseapi.exception.UserNotFoundException;
import com.example.courseapi.model.User;
import com.example.courseapi.repository.UserRepository;
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
    public User addUser(User user) {
        return this.userRepository.save(user);
    }
    public User login(User requestUser) {
        User user = this.userRepository.findUserByUsername(requestUser.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User with the username: " + requestUser.getUsername() + " was not found" ));
        if (requestUser.getPassword().equals(user.getPassword())) {
            return user;
        }
        return new User();
    }
}
