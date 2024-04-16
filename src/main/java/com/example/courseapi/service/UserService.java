package com.example.courseapi.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.courseapi.exception.UserNotFoundException;
import com.example.courseapi.model.Token;
import com.example.courseapi.model.entities.User;
import com.example.courseapi.model.requests.ChangePasswordRequest;
import com.example.courseapi.model.requests.ChangePersonalInformationRequest;
import com.example.courseapi.model.requests.ChangeUsernameRequest;
import com.example.courseapi.model.requests.LoginRequest;
import com.example.courseapi.repository.UserRepository;
import com.example.courseapi.utils.HashHandler;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public Token addUser(User requestUser) {
        User user = this.userRepository.findUserByUsername(requestUser.getUsername())
                .orElse(null);
        if (user == null) {
            requestUser.setPassword(HashHandler.sha256(requestUser.getPassword()));
            this.userRepository.save(requestUser);
            Date issuedAt = new Date();
            Algorithm algorithm = Algorithm.HMAC256("secret");

            return new Token(JWT.create()
                    .withIssuedAt(issuedAt)
                    .withClaim("username", requestUser.getUsername())
                    .withClaim("type", requestUser.getType())
                    .sign(algorithm));
        }
        return new Token("");
    }
    public Token login(LoginRequest request) {
        User user = this.userRepository.findUserByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User with the username: " + request.getUsername() + " was not found" ));
        String requestPassword = HashHandler.sha256(request.getPassword());
        if (requestPassword != null && requestPassword.equals(user.getPassword())) {

            Date issuedAt = new Date();
            Algorithm algorithm = Algorithm.HMAC256("secret");

            return new Token(JWT.create()
                    .withIssuedAt(issuedAt)
                    .withClaim("username", user.getUsername())
                    .withClaim("type", user.getType())
                    .sign(algorithm));
        }
        return new Token("");
    }

    public boolean isAuthorized(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT jwt = verifier.verify(token);

            String username = jwt.getClaim("username").asString();
            User user = userRepository.findUserByUsername(username)
                    .orElse(null);

            return user != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean changeUsername(ChangeUsernameRequest request) {
        User oldUser = this.userRepository.findUserByUsername(request.getOldUsername())
                .orElse(null);
        if (oldUser != null) {
            User newUser = this.userRepository.findUserByUsername(request.getNewUsername())
                    .orElse(null);
            oldUser.setUsername(request.getNewUsername());
            this.userRepository.save(oldUser);
            return newUser == null;
        }
        return false;
    }

    public boolean changePassword(ChangePasswordRequest request) {
        User user = this.userRepository.findUserByUsername(request.getUsername())
                .orElse(null);
        if (user != null) {
            user.setPassword(HashHandler.sha256(request.getNewPassword()));
            this.userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean changePersonalInformation(ChangePersonalInformationRequest request) {
        User user = this.userRepository.findUserByUsername(request.getUsername())
                .orElse(null);
        if (user != null) {
            user.setImagePath(request.getImagePath());
            user.setName(request.getName());
            user.setLastName(request.getLastName());
            user.setProfession(request.getProfession());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setCountry(request.getCountry());
            user.setCity(request.getCity());
            this.userRepository.save(user);
            return true;
        }
        return false;
    }


}
