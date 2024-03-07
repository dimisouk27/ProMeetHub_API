package com.promeethub_api.dal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promeethub_api.api.models.form.RegisterForm;
import com.promeethub_api.businessLayer.services.AuthService;
import com.promeethub_api.dal.repositories.ServiceProviderRepository;
import com.promeethub_api.dal.repositories.UserRepository;
import com.promeethub_api.domain.entities.ServiceProviderEntity;
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
    private final ServiceProviderRepository serviceProviderRepository;
    private final AuthService authService;
    private final ObjectMapper mapper;
    @Override
    public void run(String... args) throws Exception {

        UserEntity user = new UserEntity(null, "admin", "admin","admin@admin.be", "Test1234=!", null, null, UserRole.ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        RegisterForm registerForm = mapper.readValue("""
                {
                    "lastName": "Doe",
                    "firstName": "John",
                    "email": "John@Doe.com",
                    "password": "Test1234=",
                    "phoneNumber": "0478985768",
                    "role": "SERVICE_PROVIDER",
                    "streetNumber": 4,
                    "street": "rue Dupont",
                    "zipCode": 6000,
                    "city": "Charleroi",
                    "country": "Belgique"
                }""", RegisterForm.class);

        authService.register(registerForm.toEntity());




    }
}