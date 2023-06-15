package com.example.warehouse_data_rest_api.service;

import com.example.warehouse_data_rest_api.entity.*;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.ProductDto;
import com.example.warehouse_data_rest_api.repository.AttachmentRepository;
import com.example.warehouse_data_rest_api.repository.CategoryRepository;
import com.example.warehouse_data_rest_api.repository.MeasurementRepository;
import com.example.warehouse_data_rest_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MeasurementRepository measurementRepository;

    /**
     * Get Products
     * @return List<Product>
     */
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    /**
     * GET Product BY iD
     * @param id
     * @return Product
     */
    public Product getProduct(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    /**
     * ADD Product
     * @param productDto
     * @return ApiResponse
     */
    public ApiResponse addProduct(ProductDto productDto){

        boolean existsByCode = productRepository.existsByCode(productDto.getCode());
        if (existsByCode)
            return new ApiResponse("Code already exist", false);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getAttachmentId());
        if (optionalAttachment.isEmpty())
            return new ApiResponse("Attachment not found", false);
        Attachment attachment = optionalAttachment.get();

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty())
            return new ApiResponse("Category not found", false);
        Category category = optionalCategory.get();

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (optionalMeasurement.isEmpty())
            return new ApiResponse("Measurement not found", false);
        Measurement measurement = optionalMeasurement.get();

        Product product = new Product();
        product.setCode(productDto.getCode());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setAttachment(attachment);
        product.setMeasurement(measurement);
        product.setActive(productDto.isActive());
        productRepository.save(product);
        return new ApiResponse("Product added", true);
    }

    /**
     * EDIT Product
     * @param productDto
     * @param id
     * @return ApiResponse
     */
    public ApiResponse editProduct(ProductDto productDto, Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty())
            return new ApiResponse("Product not found", false);
        Product product = optionalProduct.get();

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getAttachmentId());
        if (optionalAttachment.isEmpty())
            return new ApiResponse("Attachment not found", false);
        Attachment attachment = optionalAttachment.get();

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty())
            return new ApiResponse("Category not found", false);
        Category category = optionalCategory.get();

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (optionalMeasurement.isEmpty())
            return new ApiResponse("Measurement not found", false);
        Measurement measurement = optionalMeasurement.get();

        product.setCode(productDto.getCode());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setAttachment(attachment);
        product.setMeasurement(measurement);
        product.setActive(productDto.isActive());
        productRepository.save(product);
        return new ApiResponse("Product edited", true);
    }

    /**
     * DELETE Product
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteProduct(Integer id){
        try {
            productRepository.deleteById(id);
            return new ApiResponse("Product deleted", true);
        }
        catch (Exception e){
            return new ApiResponse("Product not found", false);
        }
    }
}
