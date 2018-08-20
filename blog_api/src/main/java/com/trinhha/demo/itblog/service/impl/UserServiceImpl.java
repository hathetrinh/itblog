package com.trinhha.demo.itblog.service.impl;

import com.trinhha.demo.itblog.Exception.InvalidWordException;
import com.trinhha.demo.itblog.dto.User;
import com.trinhha.demo.itblog.repository.UserRepository;
import com.trinhha.demo.itblog.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = InvalidWordException.class)
    public void saveUser(User user) {
        user.setExpired(false);
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return new User();
    }
}
