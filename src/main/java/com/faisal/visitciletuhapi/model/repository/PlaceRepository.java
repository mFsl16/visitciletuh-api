package com.faisal.visitciletuhapi.model.repository;

import com.faisal.visitciletuhapi.model.entities.Place;

import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Long> {
    
}
