package com.faisal.visitciletuhapi.model.repository;

import java.util.Optional;

import com.faisal.visitciletuhapi.model.entities.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
