package com.project.proiectspring.service;

import com.project.proiectspring.exception.UserNotFoundException;
import com.project.proiectspring.model.User;
import com.project.proiectspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) { return userRepository.save(user); }

    public User update(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isEmpty()) {
            throw new UserNotFoundException();
        }
        return userRepository.save(user);
    }

    public List<User> get(String lastName, String firstName) {
        List<User> users = new ArrayList<>();

        if (lastName != null && firstName != null &&
            !lastName.isEmpty() && !firstName.isEmpty()) {
            users = userRepository.findByLastNameContainingIgnoreCaseAndFirstNameContainingIgnoreCase(lastName, firstName);
        } else {
            users = userRepository.findAll();
        }

        return users;
    }
}
