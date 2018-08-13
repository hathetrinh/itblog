package com.trinhha.demo.itblog.configuration;

import com.trinhha.demo.itblog.dto.E_Role;
import com.trinhha.demo.itblog.dto.Role;
import com.trinhha.demo.itblog.dto.User;
import com.trinhha.demo.itblog.repository.RoleRepository;
import com.trinhha.demo.itblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Inject
    private UserRepository userRepository;

    @Inject
    private RoleRepository roleRepository;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Value("${app.user.admin.email}")
    private String email;

    @Value("${app.user.admin.password}")
    private String password;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.createDefaultRole();
        this.createDefaultUser();
    }

    private void createDefaultUser() {
        if (userRepository.findUserByEmail(email) == null) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            Role role = roleRepository.findRoleByName(E_Role.ROLE_ADMIN.name());
            if (null != role) {
                user.getRoles().add(role);
            }
            userRepository.save(user);
        }
    }

    private void createDefaultRole() {
        if (roleRepository.findRoleByName(E_Role.ROLE_ADMIN.name()) == null) {
            Role role = new Role();
            role.setName(E_Role.ROLE_ADMIN.name());
            roleRepository.save(role);
        }

        if (roleRepository.findRoleByName(E_Role.ROLE_MEMBER.name()) == null) {
            Role role = new Role();
            role.setName(E_Role.ROLE_MEMBER.name());
            roleRepository.save(role);
        }

        if (roleRepository.findRoleByName(E_Role.ROLE_MODE.name()) == null) {
            Role role = new Role();
            role.setName(E_Role.ROLE_MODE.name());
            roleRepository.save(role);
        }

        if (roleRepository.findRoleByName(E_Role.ROLE_GUEST.name()) == null) {
            Role role = new Role();
            role.setName(E_Role.ROLE_GUEST.name());
            roleRepository.save(role);
        }
    }
}
