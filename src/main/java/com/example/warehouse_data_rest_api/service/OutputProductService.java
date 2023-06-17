package com.example.warehouse_data_rest_api.service;

import com.example.warehouse_data_rest_api.entity.*;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.OutputProductDto;
import com.example.warehouse_data_rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {

    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;

    /**
     * Get OutputProducts
     * @return List<OutputProduct>
     */
    public List<OutputProduct> getOutputProducts(){
        return outputProductRepository.findAll();
    }

    /**
     * GET OutputProduct BY iD
     * @param id
     * @return OutputProduct
     */
    public OutputProduct getOutputProduct(Integer id){
        Optional<OutputProduct> outputProduct = outputProductRepository.findById(id);
        return outputProduct.orElse(null);
    }

    /**
     * ADD OutputProduct
     * @param outputProductDto
     * @return ApiResponse
     */
    public ApiResponse addOutputProduct(OutputProductDto outputProductDto){

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getOutputId());
        if (optionalProduct.isEmpty())
            return new ApiResponse("OutputProduct not found", false);
        Product product = optionalProduct.get();

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (optionalOutput.isEmpty())
            return new ApiResponse("Output not found", false);
        Output output = optionalOutput.get();

        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProduct.getPrice());
        outputProduct.setProduct(product);
        outputProduct.setOutput(output);
        return new ApiResponse("OutputProduct added", true);
    }

    /**
     * EDIT OutputProduct
     * @param outputProductDto
     * @param id
     * @return ApiResponse
     */
    public ApiResponse editOutputProduct(OutputProductDto outputProductDto, Integer id) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (optionalOutputProduct.isEmpty())
            return new ApiResponse("OutputProduct not found", false);
        OutputProduct outputProduct = optionalOutputProduct.get();

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getOutputId());
        if (optionalProduct.isEmpty())
            return new ApiResponse("OutputProduct not found", false);
        Product product = optionalProduct.get();

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (optionalOutput.isEmpty())
            return new ApiResponse("Output not found", false);
        Output output = optionalOutput.get();

        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProduct.getPrice());
        outputProduct.setProduct(product);
        outputProduct.setOutput(output);
        return new ApiResponse("OutputProduct edited", true);
    }

    /**
     * DELETE OutputProduct
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteOutputProduct(Integer id){
        try {
            outputProductRepository.deleteById(id);
            return new ApiResponse("OutputProduct deleted", true);
        }
        catch (Exception e){
            return new ApiResponse("OutputProduct not found", false);
        }
    }
}
