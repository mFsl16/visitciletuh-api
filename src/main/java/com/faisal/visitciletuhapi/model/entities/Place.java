package com.faisal.visitciletuhapi.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_places")
public class Place {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required !")
    private String name;

    @ManyToOne
    private Categories categories;

    @NotEmpty(message = "Description is required !")
    @Column(length = 500)
    private String description;

    private String photo;

    @NotNull(message = "Lattitude can't be null")
    private Double lattitude;

    @NotNull(message = "Longitude can't be null")
    private Double longitude;

    public Place() {
    }

    public Place(Long id, String name, Categories categories, String description, String photo, Double lattitude,
            Double longitude) {
        this.id = id;
        this.name = name;
        this.categories = categories;
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

    public Categories getCategory() {
        return categories;
    }

    public void setCategory(Categories categories) {
        this.categories = categories;
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
