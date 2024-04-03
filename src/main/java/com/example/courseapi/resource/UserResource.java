package com.example.courseapi.resource;

import com.example.courseapi.model.User;
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
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<User> getUserByLogin(@RequestBody User requestUser) {
        User user = userService.login(requestUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
