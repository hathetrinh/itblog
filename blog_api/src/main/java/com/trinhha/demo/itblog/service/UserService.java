package com.trinhha.demo.itblog.service;

import com.trinhha.demo.itblog.dto.User;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);

    void saveUser(User user);

    List<User> findAllUsers();

    User updateUser(User user);
}
