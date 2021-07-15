package com.faisal.visitciletuhapi.controller;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.dto.ResponseData;
import com.faisal.visitciletuhapi.model.entities.AboutEntitt;
import com.faisal.visitciletuhapi.services.AboutServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/about")
public class AboutController {

    @Autowired AboutServices aboutServices;
    
    @PostMapping
    public ResponseEntity<ResponseData<AboutEntitt>> addData(@Valid @RequestBody AboutEntitt aboutEntitt, Errors errors) {

        ResponseData<AboutEntitt> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(aboutServices.addNew(aboutEntitt));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping()
    public Iterable<AboutEntitt> getAll() {
        return aboutServices.getAllData();
    }

    @GetMapping("/{id}")
    public AboutEntitt getOne(@PathVariable Long id) {
        return aboutServices.getOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<AboutEntitt>> updateData(@Valid @RequestBody AboutEntitt aboutEntitt, Errors errors) {
        
        ResponseData<AboutEntitt> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(aboutServices.addNew(aboutEntitt));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aboutServices.deleteData(id);
    }
}
