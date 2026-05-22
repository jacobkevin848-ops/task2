package com.example.firstrestapi.product.api.response;

public class ProductResponse {

    private Long id;
    private String name;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}