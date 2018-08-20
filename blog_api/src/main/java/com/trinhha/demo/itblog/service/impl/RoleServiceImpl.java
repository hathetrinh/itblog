package com.trinhha.demo.itblog.service.impl;

import com.trinhha.demo.itblog.dto.Role;
import com.trinhha.demo.itblog.service.RoleService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Inject
    com.trinhha.demo.itblog.repository.RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

}
