package com.trinhha.demo.itblog.repository;

import com.trinhha.demo.itblog.dto.DtoUser;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface User extends JpaRepository<DtoUser, Integer> {
}
