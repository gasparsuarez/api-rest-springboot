package com.devity.backend.infraestructure.datasources;

import com.devity.backend.domain.datasources.UserDatasource;
import com.devity.backend.domain.dtos.CreateUserDto;
import com.devity.backend.domain.dtos.UpdateUserDto;
import com.devity.backend.domain.entities.User;
import com.devity.backend.domain.exceptions.CustomException;
import com.devity.backend.infraestructure.db.UserDataBase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class UserDatasourceImpl implements UserDatasource {

    private final UserDataBase userDataBase;

    public UserDatasourceImpl(UserDataBase userDataBase) {
        this.userDataBase = userDataBase;
    }

    @Override
    public User getUserById(String id) throws CustomException {

        Optional<User> user = userDataBase
                .getUsers()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if(user.isEmpty()){
            throw new CustomException(HttpStatus.BAD_REQUEST,"Usuario no encontrado");
        }
        return user.get();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userDataBase.getUsers();
    }

    @Override
    public User createUser(CreateUserDto dto) throws CustomException {
        User user = new User(dto.getId(), dto.getName());

        boolean userExist = userDataBase.users
                .stream()
                .anyMatch(e -> e.getId().equals(dto.getId()));

        if(userExist){ throw new CustomException(HttpStatus.BAD_REQUEST, "El usuario ya existe"); }

        userDataBase.users.add(user);
        return user;
    }

    @Override
    public User updateUser(UpdateUserDto dto) throws CustomException {

       Optional<User> user = userDataBase.users
                .stream()
                .filter(e -> e.getId().equals(dto.getId()))
                .findFirst();

       if(user.isEmpty()) { throw new CustomException(HttpStatus.BAD_REQUEST, "El usuario no existe"); }

       User updatedUser = user.get();
       updatedUser.setName(dto.getName());

       userDataBase.users
               .forEach(e -> e = updatedUser);

       return updatedUser;
    }
}
