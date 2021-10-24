package com.kodluyoruz.userapi.service;


import com.kodluyoruz.userapi.exception.NotFoundException;
import com.kodluyoruz.userapi.model.dto.UserDto;
import com.kodluyoruz.userapi.model.entity.User;
import com.kodluyoruz.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.userapi.model.mapper.UserMapper.USER_MAPPER;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserDto getUserDto(int id) {
        User user = getUser(id);
        return USER_MAPPER.toUserDto(user);
    }

    private User getUser(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found!"));
    }

    public void incrementRegistrationsCount(int id) {
        repository.incrementRegisteredBookCount(id);
    }
}
