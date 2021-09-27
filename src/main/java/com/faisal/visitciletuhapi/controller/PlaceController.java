package com.faisal.visitciletuhapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.dto.ResponseData;
import com.faisal.visitciletuhapi.dto.SearchKeyDTO;
import com.faisal.visitciletuhapi.model.entities.Categories;
import com.faisal.visitciletuhapi.model.entities.Place;
import com.faisal.visitciletuhapi.services.CategorysServices;
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

    @Autowired CategorysServices categorysServices;
    
    @PostMapping
    public ResponseEntity<ResponseData<Place>> addData(@Valid @RequestBody Place place, Errors errors) {
        
        ResponseData<Place> responseData = new ResponseData<>();

        Categories categories = categorysServices.getOneCategory(place.getCategory().getId());

        if(errors.hasErrors()) {
            for(ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        System.out.println(">>>>>>>>>" + place.getCategory().getId());

        if(categories == null) {
            responseData.getMessage().add("Wrong category!");
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setStatus(true);
        responseData.setPayload(placeServices.addHotel(place));
        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/search/name")
    public List<Place> findByName(@RequestBody SearchKeyDTO searchKeyDTO) {
        return placeServices.findByName("%" + searchKeyDTO.getKeyword() + "%");
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
