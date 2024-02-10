package com.promeethub_api.businessLayer.services.impl;

import com.promeethub_api.dal.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//Au début j'ai implémenté userDetailsService dans userService mais le soucis c'est que ça crée
//une boucle de dépendance entre userServiceImpl et authenticationManager
@RequiredArgsConstructor
@Service
public class userDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
}
