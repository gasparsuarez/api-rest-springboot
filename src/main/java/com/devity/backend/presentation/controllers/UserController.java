package com.devity.backend.presentation.controllers;

import com.devity.backend.domain.dtos.CreateUserDto;
import com.devity.backend.domain.dtos.UpdateUserDto;
import com.devity.backend.domain.entities.User;
import com.devity.backend.domain.exceptions.CustomException;
import com.devity.backend.infraestructure.repositories.UserRepositoryImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;


@RestController
@RequestMapping("/api/users/")
public class UserController {

        private final UserRepositoryImpl userRepository;

        @Autowired
        public UserController(UserRepositoryImpl userRepository) {
            this.userRepository = userRepository;
        }

        @RequestMapping("{id}")
        ResponseEntity<User> getUserById(@PathVariable String id) throws CustomException{
            User user = userRepository.getUserById(id);

            return ResponseEntity.ok().body(user);
        }

        @GetMapping("all")
        ResponseEntity<ArrayList<User>> getAllUsers(){
            return ResponseEntity.ok().body(userRepository.getAllUsers());
        }

        @PostMapping
        ResponseEntity<User> createUser(@Valid @RequestBody CreateUserDto dto) throws CustomException {

            User user = userRepository.createUser(dto);

            return ResponseEntity.status(201).body(user);
        };

        @PutMapping()
        ResponseEntity<User> updateUser(@Valid @RequestBody UpdateUserDto dto) throws CustomException {

            User user = userRepository.updateUser(dto);

            return ResponseEntity.ok().body(user);
        }
}
