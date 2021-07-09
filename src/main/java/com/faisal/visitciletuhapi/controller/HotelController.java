package com.faisal.visitciletuhapi.controller;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.model.entities.Hotel;
import com.faisal.visitciletuhapi.services.HotelServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hotel")
public class HotelController {

    @Autowired HotelServices hotelServices;
    
    @PostMapping
    public Hotel addData(@Valid @RequestBody Hotel hotel, Errors errors) {
        return hotelServices.addHotel(hotel);
    }

    @GetMapping()
    public Iterable<Hotel> getAll() {
        return hotelServices.getAllHotel();
    }

    @GetMapping("/{id}")
    public Hotel getOne(@PathVariable Long id) {
        return hotelServices.getOneHotel(id);
    }

    @PutMapping
    public Hotel updateData(@Valid @RequestBody Hotel hotel, Errors errors) {
        return hotelServices.addHotel(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hotelServices.deleteHotel(id);;
    }
}
