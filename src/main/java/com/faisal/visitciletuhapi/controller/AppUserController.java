package com.faisal.visitciletuhapi.controller;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.dto.AppUserDto;
import com.faisal.visitciletuhapi.dto.ResponseData;
import com.faisal.visitciletuhapi.model.entities.AppUser;
import com.faisal.visitciletuhapi.model.entities.AppUserRole;
import com.faisal.visitciletuhapi.services.AppUserServices;
import com.faisal.visitciletuhapi.utils.ModelMapperUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user")
public class AppUserController {
    
    @Autowired
    private AppUserServices appUserServices;

    @Autowired
    private ModelMapperUtil modelMapperUtil;

    @PostMapping(path = "register")
    public ResponseEntity<ResponseData<AppUser>> registerAppUser(@Valid @RequestBody AppUserDto appUserDto, Errors errors) {
        
        ResponseData<AppUser> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage().toString());
            }

            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        appUserDto.setAppUserRole(AppUserRole.USER);
        AppUser appUser = modelMapperUtil.modelMapper().map(appUserDto, AppUser.class);

        responseData.setStatus(true);
        responseData.setPayload(appUserServices.registerAppUser(appUser));
        return ResponseEntity.ok(responseData);
    }
}
