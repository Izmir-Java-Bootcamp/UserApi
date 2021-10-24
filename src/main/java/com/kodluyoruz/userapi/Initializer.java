package com.kodluyoruz.userapi;

import com.kodluyoruz.userapi.model.entity.User;
import com.kodluyoruz.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            userRepository.save(
                    User.builder()
                            .username("test user " + i)
                            .registeredBookCount(0)
                            .build());
        }

    }
}
