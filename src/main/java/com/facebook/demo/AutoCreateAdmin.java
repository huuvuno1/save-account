package com.facebook.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AutoCreateAdmin {
    @Autowired
    private UserRepository userRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        UserEntity userEntity = userRepository.findByUsername("admin");
        if (userEntity == null)
            userRepository.save(new UserEntity("admin", "admin-nguyenhuuvu-nguyencongminh"));
    }
}
