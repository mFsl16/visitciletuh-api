package com.faisal.visitciletuhapi.controller;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.model.entities.Wisata;
import com.faisal.visitciletuhapi.services.WisataServices;

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
@RequestMapping("api/wisata")
public class WisataController {
    
    @Autowired WisataServices wisataServices;

    @PostMapping
    public Wisata addData(@Valid @RequestBody Wisata wisata, Errors errors) {
        return wisataServices.addNewPlace(wisata);
    }

    @GetMapping()
    public Iterable<Wisata> getAll() {
        return wisataServices.getAllPlaces();
    }

    @GetMapping("/{id}")
    public Wisata getOne(@PathVariable Long id) {
        return wisataServices.getOnePlace(id);
    }

    @PutMapping
    public Wisata updateData(@Valid @RequestBody Wisata wisata, Errors errors) {
        return wisataServices.addNewPlace(wisata);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wisataServices.delete(id);
    }
}
