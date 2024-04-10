package com.example.courseapi.resource;

import com.example.courseapi.exception.UserNotFoundException;
import com.example.courseapi.model.Token;
import com.example.courseapi.model.entities.User;
import com.example.courseapi.model.requests.ChangePasswordRequest;
import com.example.courseapi.model.requests.ChangePersonalInformationRequest;
import com.example.courseapi.model.requests.ChangeUsernameRequest;
import com.example.courseapi.model.requests.LoginRequest;
import com.example.courseapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    public UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User user = userService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Boolean> addUser(@RequestBody User user) {
        boolean response = userService.addUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody LoginRequest request) {
        Token response;
        try {
            response = userService.login(request);
        } catch (UserNotFoundException e) {
            response = new Token("");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/change-username")
    public ResponseEntity<Boolean> changeUsername(@RequestBody ChangeUsernameRequest request) {
        boolean response;
        try {
            response = userService.changeUsername(request);
        } catch (UserNotFoundException e) {
            response = false;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/change-password")
    public ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordRequest request) {
        boolean response;
        try {
            response = userService.changePassword(request);
        } catch (UserNotFoundException e) {
            response = false;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/change-personal-information")
    public ResponseEntity<Boolean> changePersonalInformation(@RequestBody ChangePersonalInformationRequest request) {
        boolean response;
        try {
            response = userService.changePersonalInformation(request);
        } catch (UserNotFoundException e) {
            response = false;
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
