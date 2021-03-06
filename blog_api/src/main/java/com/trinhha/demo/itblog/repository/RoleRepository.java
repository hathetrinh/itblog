package com.trinhha.demo.itblog.repository;

import com.trinhha.demo.itblog.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByName(String role);
}
