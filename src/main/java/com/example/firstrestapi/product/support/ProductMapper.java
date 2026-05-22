package com.example.firstrestapi.product.support;

import com.example.firstrestapi.product.api.request.ProductRequest;
import com.example.firstrestapi.product.api.request.UpdateProductRequest;
import com.example.firstrestapi.product.api.response.ProductResponse;
import com.example.firstrestapi.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return new Product(request.getName());
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }

    public void updateProduct(Product product, UpdateProductRequest request) {
        product.setName(request.getName());
    }
}