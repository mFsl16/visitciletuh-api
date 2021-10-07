package com.faisal.visitciletuhapi.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.faisal.visitciletuhapi.model.entities.AppUserRole;

public class AppUserDto {
    
    @NotEmpty(message = "Name Cant be empty")
    private String name;

    @Email(message = "Email not valid")
    private String email;

    @NotEmpty(message = "Password cant be empty")
    private String Password;
    private AppUserRole appUserRole;

    public AppUserDto(@NotEmpty(message = "Name Cant be empty") String name,
            @Email(message = "Email not valid") String email, @NotEmpty String password, AppUserRole appUserRole) {
        this.name = name;
        this.email = email;
        Password = password;
        this.appUserRole = appUserRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }
}
