package com.project.proiectspring.controller;

import com.project.proiectspring.dto.CreateUserDto;
import com.project.proiectspring.mapper.UserMapper;
import com.project.proiectspring.model.User;
import com.project.proiectspring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> get(
            @RequestParam(required = false)
            String lastName,
            @RequestParam(required = false)
            String firstName) {

        return userService.get(lastName, firstName);
    }

    @PostMapping
    public ResponseEntity<User> create(
            @RequestBody
            @Valid
            CreateUserDto createUserDto
    ) {
        User user = userMapper.createUserDtoToUser(createUserDto);
        User createdUser = userService.create(user);
        return ResponseEntity.created(URI.create("/users/" + createdUser))
                .body(createdUser);
    }

}
