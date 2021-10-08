package com.faisal.visitciletuhapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.dto.PlaceDto;
import com.faisal.visitciletuhapi.dto.ResponseData;
import com.faisal.visitciletuhapi.model.entities.Categories;
import com.faisal.visitciletuhapi.model.entities.Place;
import com.faisal.visitciletuhapi.services.CategorysServices;
import com.faisal.visitciletuhapi.services.PlaceServices;
import com.faisal.visitciletuhapi.utils.ModelMapperUtil;

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

    @Autowired CategorysServices categorysServices;

    @Autowired ModelMapperUtil modelMapperUtil;
    
    @PostMapping
    public ResponseEntity<ResponseData<Place>> addData(@Valid @RequestBody PlaceDto placeDto, Errors errors) {
        
        ResponseData<Place> responseData = new ResponseData<>();

        List<Categories> categories = categorysServices.findByName(placeDto.getCategories());

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        if(categories == null) {
            responseData.getMessage().add("Wrong category!");
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Place place = modelMapperUtil.modelMapper().map(placeDto, Place.class);
        place.setCategory(categories.get(0));

        responseData.setStatus(true);
        responseData.setPayload(placeServices.addHotel(place));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/search/{name}")
    public List<Place> findByName(@PathVariable String name) {
        return placeServices.findByName("%" + name + "%");
    }

    @GetMapping()
    public Iterable<Place> getAll() {
        return placeServices.getAllHotel();
    }

    @GetMapping("/{id}")
    public Place getOne(@PathVariable Long id) {
        return placeServices.getOneHotel(id);
    }

    @GetMapping("/search/{categoryName}")
    public List<Place> findByCategory(@PathVariable String categoryName) {
        return placeServices.findByCategory("%" + categoryName + "%");
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
