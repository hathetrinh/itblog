package com.trinhha.demo.itblog.service;

import com.trinhha.demo.itblog.dto.DtoRole;
import com.trinhha.demo.itblog.repository.Role;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Inject
    Role role;

    @Override
    public List<DtoRole> getAllRoles() {
        return role.findAll();
    }
}
