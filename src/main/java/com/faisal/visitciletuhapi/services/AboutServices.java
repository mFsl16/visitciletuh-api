package com.faisal.visitciletuhapi.services;

import java.util.Optional;

import com.faisal.visitciletuhapi.model.entities.AboutEntitt;
import com.faisal.visitciletuhapi.model.repository.AboutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AboutServices {
    
    @Autowired AboutRepository aboutRepository;

    public AboutEntitt addNew(AboutEntitt aboutEntitt) {
        return aboutRepository.save(aboutEntitt);
    }

    public Iterable<AboutEntitt> getAllData() {
        return aboutRepository.findAll();
    }

    public AboutEntitt getOne(Long id) {
        Optional<AboutEntitt> temp = aboutRepository.findById(id);

        if(!temp.isPresent()) {
            return null;
        }

        return temp.get();
    }

    public void deleteData(Long id) {
        aboutRepository.deleteById(id);
    }
}
