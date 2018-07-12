package com.trinhha.demo.itblog.repository;

import com.trinhha.demo.itblog.dto.DtoRole;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Role extends JpaRepository<DtoRole, Integer> {
}
