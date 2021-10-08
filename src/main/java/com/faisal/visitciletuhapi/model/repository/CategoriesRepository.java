package com.faisal.visitciletuhapi.model.repository;

import java.util.List;

import com.faisal.visitciletuhapi.model.entities.Categories;

import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories, Long> {
    List<Categories> findByName(String name);
}
