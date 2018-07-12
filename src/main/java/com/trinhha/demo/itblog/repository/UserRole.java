package com.trinhha.demo.itblog.repository;

import com.trinhha.demo.itblog.dto.DtoUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRole extends JpaRepository<DtoUserRole, Integer> {
}
