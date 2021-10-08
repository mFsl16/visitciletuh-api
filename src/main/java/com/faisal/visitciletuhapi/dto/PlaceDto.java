package com.faisal.visitciletuhapi.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

public class PlaceDto {
    
    @NotEmpty(message = "Name cant be empty")
    private String name;

    @NotEmpty(message = "Please add category")
    private String categories;

    @NotEmpty(message = "Description cant be empty")
    private String description;

    private String photo;

    @DecimalMin("-90") @DecimalMax("90")
    private Double lattitude;

    @DecimalMin("-180") @DecimalMax("180")
    private Double longitude;

    public PlaceDto(@NotEmpty(message = "Name cant be empty") String name,
            @NotEmpty(message = "Please add category") String categories,
            @NotEmpty(message = "Description cant be empty") String description, String photo,
            @DecimalMin("-90") @DecimalMax("90") Double lattitude,
            @DecimalMin("-180") @DecimalMax("180") Double longitude) {
        this.name = name;
        this.categories = categories;
        this.description = description;
        this.photo = photo;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
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
