package com.faisal.visitciletuhapi.dto;

public class SearchKeyDTO {
    
    private String keyword;

    public SearchKeyDTO(String keyword) {
        this.keyword = keyword;
    }

    public SearchKeyDTO() {
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
