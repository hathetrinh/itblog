package com.trinhha.demo.itblog.service.impl;

import com.trinhha.demo.itblog.dto.User;
import com.trinhha.demo.itblog.repository.UserRepository;
import com.trinhha.demo.itblog.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setExpired(false);
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
