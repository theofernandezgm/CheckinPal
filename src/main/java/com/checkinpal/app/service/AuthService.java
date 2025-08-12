// src/main/java/com/yourcompany/app/service/AuthService.java
package com.checkinpal.app.service;

import com.checkinpal.app.domain.HostAccount;
import com.checkinpal.app.domain.Role;
import com.checkinpal.app.domain.User;
import com.checkinpal.app.repository.HostAccountRepository;
import com.checkinpal.app.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final HostAccountRepository hostAccountRepository;
    private final PasswordEncoder passwordEncoder;

    // Spring injects the dependencies we need
    public AuthService(UserRepository userRepository, HostAccountRepository hostAccountRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.hostAccountRepository = hostAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerOwner(String email, String rawPassword, String legalName, String nif) {
        // 1. Create the User entity
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPasswordHash(passwordEncoder.encode(rawPassword)); // Hash the password
        newUser.setRole(Role.OWNER);
        User savedUser = userRepository.save(newUser);

        // 2. Create the linked HostAccount
        HostAccount newHostAccount = new HostAccount();
        newHostAccount.setOwner(savedUser);
        newHostAccount.setLegalName(legalName);
        newHostAccount.setNif(nif);
        hostAccountRepository.save(newHostAccount);

        return savedUser;
    }
}