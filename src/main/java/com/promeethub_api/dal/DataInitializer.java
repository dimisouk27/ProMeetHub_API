package com.promeethub_api.dal;

import com.promeethub_api.dal.repositories.UserRepository;
import com.promeethub_api.domain.entities.UserEntity;
import com.promeethub_api.domain.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

        UserEntity user = new UserEntity(null, "admin", "admin","admin@admin.be", "Test1234=!", null, null, UserRole.ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
}