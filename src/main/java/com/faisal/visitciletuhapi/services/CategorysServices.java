package com.faisal.visitciletuhapi.services;

import java.util.List;
import java.util.Optional;

import com.faisal.visitciletuhapi.model.entities.Categories;
import com.faisal.visitciletuhapi.model.repository.CategoriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategorysServices {
    
    @Autowired CategoriesRepository categoriesRepository;

    public Categories addCategory(Categories categories) {
        return categoriesRepository.save(categories);
    }

    public Iterable<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public Categories getOneCategory(Long id) {
        Optional<Categories> temp = categoriesRepository.findById(id);

        if (!temp.isPresent()) {
            return null;
        }
        return temp.get();
    }

    public Categories updateCategory(Categories categories) {
        return categoriesRepository.save(categories);
    }

    public void deleteById(Long id) {
        categoriesRepository.deleteById(id);
    }

    public List<Categories> findByName(String name) {
        return categoriesRepository.findByName(name);
    }
}
