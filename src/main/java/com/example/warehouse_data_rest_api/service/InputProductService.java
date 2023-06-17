package com.example.warehouse_data_rest_api.service;

import com.example.warehouse_data_rest_api.entity.*;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.InputProductDto;
import com.example.warehouse_data_rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {

    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;

    /**
     * Get InputProducts
     * @return List<InputProduct>
     */
    public List<InputProduct> getInputProducts(){
        return inputProductRepository.findAll();
    }

    /**
     * GET InputProduct BY iD
     * @param id
     * @return InputProduct
     */
    public InputProduct getInputProduct(Integer id){
        Optional<InputProduct> inputProduct = inputProductRepository.findById(id);
        return inputProduct.orElse(null);
    }

    /**
     * ADD InputProduct
     * @param inputProductDto
     * @return ApiResponse
     */
    public ApiResponse addInputProduct(InputProductDto inputProductDto){

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (optionalProduct.isEmpty())
            return new ApiResponse("Product not found", false);
        Product product = optionalProduct.get();

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (optionalInput.isEmpty())
            return new ApiResponse("Input not found", false);
        Input input = optionalInput.get();

        InputProduct inputProduct = new InputProduct();
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProduct.getPrice());
        inputProduct.setExpireDate(inputProduct.getExpireDate());
        inputProduct.setProduct(product);
        inputProduct.setInput(input);
        return new ApiResponse("InputProduct added", true);
    }

    /**
     * EDIT InputProduct
     * @param inputProductDto
     * @param id
     * @return ApiResponse
     */
    public ApiResponse editInputProduct(InputProductDto inputProductDto, Integer id) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isEmpty())
            return new ApiResponse("InputProduct not found", false);
        InputProduct inputProduct = optionalInputProduct.get();

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (optionalProduct.isEmpty())
            return new ApiResponse("Product not found", false);
        Product product = optionalProduct.get();

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (optionalInput.isEmpty())
            return new ApiResponse("Input not found", false);
        Input input = optionalInput.get();

        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProduct.getPrice());
        inputProduct.setExpireDate(inputProduct.getExpireDate());
        inputProduct.setProduct(product);
        inputProduct.setInput(input);
        return new ApiResponse("InputProduct edited", true);
    }

    /**
     * DELETE InputProduct
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteInputProduct( Integer id){
        try {
            inputProductRepository.deleteById(id);
            return new ApiResponse("InputProduct deleted", true);
        }
        catch (Exception e){
            return new ApiResponse("InputProduct not found", false);
        }
    }
}
