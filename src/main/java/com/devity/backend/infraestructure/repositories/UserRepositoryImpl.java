package com.devity.backend.infraestructure.repositories;

import com.devity.backend.domain.dtos.CreateUserDto;
import com.devity.backend.domain.dtos.UpdateUserDto;
import com.devity.backend.domain.entities.User;
import com.devity.backend.domain.exceptions.CustomException;
import com.devity.backend.domain.repositories.UserRepository;
import com.devity.backend.infraestructure.datasources.UserDatasourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final UserDatasourceImpl userDatasource;

    @Autowired
    private UserRepositoryImpl(UserDatasourceImpl userDatasource) {
        this.userDatasource = userDatasource;
    }

    @Override
    public User getUserById(String id) throws CustomException {
        return userDatasource.getUserById(id);
    }

    @Override
    public ArrayList<User> getAllUsers() { return userDatasource.getAllUsers(); }

    @Override
    public User createUser(CreateUserDto dto) throws CustomException { return userDatasource.createUser(dto); }

    @Override
    public User updateUser(UpdateUserDto dto) throws CustomException { return userDatasource.updateUser(dto); }

}
