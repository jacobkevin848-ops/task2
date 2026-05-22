package com.example.firstrestapi.product.service;

import com.example.firstrestapi.product.api.request.ProductRequest;
import com.example.firstrestapi.product.api.request.UpdateProductRequest;
import com.example.firstrestapi.product.api.response.ProductResponse;
import com.example.firstrestapi.product.domain.Product;
import com.example.firstrestapi.product.repository.ProductRepository;
import com.example.firstrestapi.product.support.ProductExceptionSupplier;
import com.example.firstrestapi.product.support.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductExceptionSupplier productExceptionSupplier;

    public ProductService(
            ProductRepository productRepository,
            ProductMapper productMapper,
            ProductExceptionSupplier productExceptionSupplier
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productExceptionSupplier = productExceptionSupplier;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        Product savedProduct = productRepository.save(product);

        return productMapper.toProductResponse(savedProduct);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(productExceptionSupplier.productNotFound(id));

        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(productExceptionSupplier.productNotFound(id));

        productMapper.updateProduct(product, request);

        Product updatedProduct = productRepository.save(product);

        return productMapper.toProductResponse(updatedProduct);
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(productExceptionSupplier.productNotFound(id));

        productRepository.delete(product);
    }
}
