package com.faisal.visitciletuhapi.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;
@Entity
@Table(name = "tbl_wisata")
public class Wisata implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cattegori;

    @Column(length = 500)
    private String description;

    private List<String> photo;

    private Double lattitude;

    private Double longitude;

    public Wisata() {
    }

    public Wisata(Long id, String name, String cattegori, String description, List<String> photo, Double lattitude,
            Double longitude) {
        this.id = id;
        this.name = name;
        this.cattegori = cattegori;
        this.description = description;
        this.photo = photo;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCattegori() {
        return cattegori;
    }

    public void setCattegori(String cattegori) {
        this.cattegori = cattegori;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }

    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
