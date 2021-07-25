package com.facebook.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class Controller {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        if (!"admin".equals(user.getUsername()))
            userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/fetch-all")
    public ResponseEntity<?> fetchALlUser(@RequestBody UserEntity user) {
        UserEntity userEntity = userRepository.findByUsername("admin");
        if (userEntity != null && userEntity.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Bạn đéo có quyền", HttpStatus.UNAUTHORIZED);
    }
}
