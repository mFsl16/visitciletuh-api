package com.faisal.visitciletuhapi.services;

import java.util.Optional;

import com.faisal.visitciletuhapi.model.entities.Wisata;
import com.faisal.visitciletuhapi.model.repository.WisataRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class WisataServices {
    
    @Autowired WisataRepository wisataRepository;

    public Wisata addNewPlace(Wisata wisata) {
        return wisataRepository.save(wisata);
    }

    public Wisata getOnePlace(Long id) {
        Optional<Wisata> places = wisataRepository.findById(id);

        if(!places.isPresent()) {
            return null;
        }

        return places.get();
    }

    public Iterable<Wisata> getAllPlaces() {
        return wisataRepository.findAll();
    }

    public void delete(Long id) {
        wisataRepository.deleteById(id);
    } 

}
