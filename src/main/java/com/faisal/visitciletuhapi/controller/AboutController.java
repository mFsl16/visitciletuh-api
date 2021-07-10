package com.faisal.visitciletuhapi.controller;

import javax.validation.Valid;

import com.faisal.visitciletuhapi.model.entities.AboutEntitt;
import com.faisal.visitciletuhapi.services.AboutServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/about")
public class AboutController {

    @Autowired AboutServices aboutServices;
    
    @PostMapping
    public AboutEntitt addData(@Valid @RequestBody AboutEntitt aboutEntitt, Errors errors) {

        if(errors.hasErrors()) {
            System.out.println("Errors");
        }

        return aboutServices.addNew(aboutEntitt);
    }

    @GetMapping()
    public Iterable<AboutEntitt> getAll() {
        return aboutServices.getAllData();
    }

    @GetMapping("/{id}")
    public AboutEntitt getOne(@PathVariable Long id) {
        return aboutServices.getOne(id);
    }

    @PutMapping
    public AboutEntitt updateData(@Valid @RequestBody AboutEntitt aboutEntitt, Errors errors) {
        return aboutServices.addNew(aboutEntitt);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aboutServices.deleteData(id);
    }
}
