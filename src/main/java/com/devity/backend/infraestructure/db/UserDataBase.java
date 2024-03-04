package com.devity.backend.infraestructure.db;

import com.devity.backend.domain.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class UserDataBase {

    public List<User> users;
    UserDataBase(){
        List<User> users = new ArrayList<>();
       users.add(new User("1", "Gaspar"));
        users.add(new User("2", "Tomas"));
        users.add(new User("3", "Martin"));
        this.users = users;
    }

    }

