package com.faisal.visitciletuhapi.services;

import javax.transaction.Transactional;

import com.faisal.visitciletuhapi.model.entities.AppUser;
import com.faisal.visitciletuhapi.model.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AppUserServices implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return appUserRepository.findByEmail(email).
        orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found.", email)));
    }

    public AppUser registerAppUser(AppUser appUser) {
        if (appUserRepository.findByEmail(appUser.getUsername()).isPresent()) {
            throw new IllegalStateException(String.format("User with email %s already exist.", appUser.getUsername()));
        }

        String passwordEncoded = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(passwordEncoded);

        return appUserRepository.save(appUser);
    }
    
}
