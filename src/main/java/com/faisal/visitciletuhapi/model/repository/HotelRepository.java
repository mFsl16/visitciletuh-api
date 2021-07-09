package com.faisal.visitciletuhapi.model.repository;

import com.faisal.visitciletuhapi.model.entities.Hotel;

import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
    
}
