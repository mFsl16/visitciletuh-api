package com.faisal.visitciletuhapi.services;

import java.util.Optional;

import com.faisal.visitciletuhapi.model.entities.Place;
import com.faisal.visitciletuhapi.model.repository.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlaceServices {
    
    @Autowired PlaceRepository hotelRepository;

    public Place addHotel(Place hotel) {
        return hotelRepository.save(hotel);
    }

    public Place getOneHotel(Long id) {
        Optional<Place> temp = hotelRepository.findById(id);

        if (!temp.isPresent()) {
            return null;
        }

        return temp.get();
    }

    public Iterable<Place> getAllHotel() {
        return hotelRepository.findAll();
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
