package com.faisal.visitciletuhapi.controller;

import java.util.stream.StreamSupport;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.dto.ResponseData;
import com.faisal.visitciletuhapi.model.entities.Categories;
import com.faisal.visitciletuhapi.services.CategorysServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {
    
    @Autowired CategorysServices categorysServices;

    @PostMapping
    public ResponseEntity<ResponseData<Categories>> add(@Valid @RequestBody Categories categories, Errors errors) {
        
        ResponseData<Categories> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(categorysServices.addCategory(categories));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Iterable<Categories>>> getAll() {
        
        ResponseData<Iterable<Categories>> responseData = new ResponseData<>();

        Iterable<Categories> data = categorysServices.getAllCategories();

        if(StreamSupport.stream(data.spliterator(), false).count() == 0) {
            responseData.getMessage().add("Data not Found");
            responseData.setStatus(true);
            responseData.setPayload(null);
            return ResponseEntity.ok(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(data);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<Categories>> getById(@PathVariable Long id) {
        ResponseData<Categories> responseData = new ResponseData<>();

        Categories data = categorysServices.getOneCategory(id);

        if (data == null) {
            responseData.setStatus(true);
            responseData.setPayload(null);
            responseData.getMessage().add("Data not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(data);
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Categories>> update(@Valid @RequestBody Categories categories, Errors errors) {
        
        ResponseData<Categories> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(categorysServices.addCategory(categories));
        return ResponseEntity.ok(responseData);
    }
}
