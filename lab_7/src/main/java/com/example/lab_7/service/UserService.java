package com.example.lab_7.service;

import com.example.lab_7.dto.UserDto;
import com.example.lab_7.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
