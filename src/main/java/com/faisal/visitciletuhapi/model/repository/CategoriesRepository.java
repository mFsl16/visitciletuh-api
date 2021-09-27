package com.faisal.visitciletuhapi.model.repository;

import com.faisal.visitciletuhapi.model.entities.Categories;

import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories, Long> {
    
}
