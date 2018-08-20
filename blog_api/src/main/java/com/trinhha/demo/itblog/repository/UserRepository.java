package com.trinhha.demo.itblog.repository;

import com.trinhha.demo.itblog.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<com.trinhha.demo.itblog.dto.User, Integer> {
    User findUserByEmail(String email);
}
