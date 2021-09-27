package com.faisal.visitciletuhapi.model.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import com.faisal.visitciletuhapi.model.entities.Place;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Long> {

    @Query("select p from Place p WHERE p.name LIKE :name")
    List<Place> findByNameLike(@PathParam("name") String name);

    @Query("select p from Place p WHERE p.categories.name LIKE :categoryName")
    List<Place> findByCategoryLike(@PathParam("categoryName") String categoryName);
    
}
