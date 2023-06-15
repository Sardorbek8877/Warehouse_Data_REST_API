package com.example.warehouse_data_rest_api.controller;

import com.example.warehouse_data_rest_api.entity.Product;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.ProductDto;
import com.example.warehouse_data_rest_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Get Products
     * @return List<Product>
     */
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * GET Product BY iD
     * @param id
     * @return Product
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    /**
     * ADD Product
     * @param productDto
     * @return ApiResponse
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto){
        ApiResponse apiResponse = productService.addProduct(productDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * EDIT Product
     * @param productDto
     * @param id
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editProduct(@RequestBody ProductDto productDto, @PathVariable Integer id){
        ApiResponse apiResponse = productService.editProduct(productDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * DELETE Product
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id){
        ApiResponse apiResponse = productService.deleteProduct(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
