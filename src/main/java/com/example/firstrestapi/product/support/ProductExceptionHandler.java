package com.example.firstrestapi.product.support;

import com.example.firstrestapi.product.support.exception.ProductNotFoundException;
import com.example.firstrestapi.shared.api.response.ErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorMessageResponse response = new ErrorMessageResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
