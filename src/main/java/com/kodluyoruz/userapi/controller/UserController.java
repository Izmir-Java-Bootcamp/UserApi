package com.kodluyoruz.userapi.controller;

import com.kodluyoruz.userapi.model.dto.UserDto;
import com.kodluyoruz.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable int id) {
        return service.getUserDto(id);
    }

    @PutMapping("{id}/increment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void incrementCount(@PathVariable int id) {
        service.incrementRegistrationsCount(id);
    }
}
