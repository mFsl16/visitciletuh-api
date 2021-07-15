package com.faisal.visitciletuhapi.controller;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.dto.ResponseData;
import com.faisal.visitciletuhapi.model.entities.Place;
import com.faisal.visitciletuhapi.services.PlaceServices;

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
@RequestMapping("api/places")
public class PlaceController {

    @Autowired PlaceServices placeServices;
    
    @PostMapping
    public ResponseEntity<ResponseData<Place>> addData(@Valid @RequestBody Place hotel, Errors errors) {
        
        ResponseData<Place> responseData = new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(placeServices.addHotel(hotel));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping()
    public Iterable<Place> getAll() {
        return placeServices.getAllHotel();
    }

    @GetMapping("/{id}")
    public Place getOne(@PathVariable Long id) {
        return placeServices.getOneHotel(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Place>> updateData(@Valid @RequestBody Place hotel, Errors errors) {
        
        ResponseData<Place> responseData =  new ResponseData<>();

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(placeServices.addHotel(hotel));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        placeServices.deleteHotel(id);;
    }
}
