package com.facebook.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
