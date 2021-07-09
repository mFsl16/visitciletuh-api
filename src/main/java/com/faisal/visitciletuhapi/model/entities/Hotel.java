package com.faisal.visitciletuhapi.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_hotel")
public class Hotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required !")
    private String name;

    @NotEmpty(message = "Categori is required !")
    private String cattegori;

    @NotEmpty(message = "Description is required !")
    @Column(length = 500)
    private String description;

    @NotEmpty(message = "Photo is required !")
    private String photo;

    @NotEmpty(message = "Lattitude is required !")
    private Double lattitude;

    @NotEmpty(message = "Longitude is required !")
    private Double longitude;

    public Hotel() {
    }

    public Hotel(Long id, String name, String cattegori, String description, String photo, Double lattitude,
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
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
