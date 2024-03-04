package com.devity.backend.domain.datasources;

import com.devity.backend.domain.dtos.CreateUserDto;
import com.devity.backend.domain.dtos.UpdateUserDto;
import com.devity.backend.domain.entities.User;
import com.devity.backend.domain.exceptions.CustomException;

import java.util.ArrayList;
import java.util.Optional;

public interface UserDatasource {
    User getUserById(String id) throws CustomException;
    ArrayList<User> getAllUsers();
    User createUser(CreateUserDto dto) throws CustomException;
    User updateUser(UpdateUserDto dto) throws CustomException;
}
