package com.trinhha.demo.itblog.service.impl;

import com.trinhha.demo.itblog.dto.Role;
import com.trinhha.demo.itblog.dto.User;
import com.trinhha.demo.itblog.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@Log4j2
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Inject
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (null == user) {
            log.error("Could not find user: " + email);
            throw new UsernameNotFoundException("Could not find user: " + email);
        }

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        Set<Role> roles = user.getRoles();
        roles.forEach(role -> grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(), grantedAuthoritySet);
    }
}
