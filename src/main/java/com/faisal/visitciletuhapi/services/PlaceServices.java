package com.faisal.visitciletuhapi.services;

import java.util.List;
import java.util.Optional;

import com.faisal.visitciletuhapi.model.entities.Place;
import com.faisal.visitciletuhapi.model.repository.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlaceServices {
    
    @Autowired PlaceRepository placeRepository;

    public Place addHotel(Place place) {
        return placeRepository.save(place);
    }

    public Place getOneHotel(Long id) {
        Optional<Place> temp = placeRepository.findById(id);

        if (!temp.isPresent()) {
            return null;
        }

        return temp.get();
    }

    public Iterable<Place> getAllHotel() {
        return placeRepository.findAll();
    }

    public void deleteHotel(Long id) {
        placeRepository.deleteById(id);
    }

    public List<Place> findByCategory(String categoryName) {
        return placeRepository.findByCategoryLike(categoryName);
    }  

    public List<Place> findByName(String name) {
        return placeRepository.findByNameLike(name);
    }
}
