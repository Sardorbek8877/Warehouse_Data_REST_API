package com.example.warehouse_data_rest_api.controller;

import com.example.warehouse_data_rest_api.entity.InputProduct;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.InputProductDto;
import com.example.warehouse_data_rest_api.service.InputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inputProduct")
public class InputProductController {

    @Autowired
    InputProductService inputProductService;

    /**
     * Get InputProducts
     * @return List<InputProduct>
     */
    @GetMapping
    public ResponseEntity<List<InputProduct>> getInputProducts(){
        List<InputProduct> inputProducts = inputProductService.getInputProducts();
        return ResponseEntity.ok(inputProducts);
    }

    /**
     * GET InputProduct BY iD
     * @param id
     * @return InputProduct
     */
    @GetMapping("/{id}")
    public ResponseEntity<InputProduct> getInputProduct(@PathVariable Integer id){
        InputProduct inputProduct = inputProductService.getInputProduct(id);
        return ResponseEntity.ok(inputProduct);
    }

    /**
     * ADD InputProduct
     * @param inputProductDto
     * @return ApiResponse
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addInputProduct(@RequestBody InputProductDto inputProductDto){
        ApiResponse apiResponse = inputProductService.addInputProduct(inputProductDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * EDIT InputProduct
     * @param inputProductDto
     * @param id
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editInputProduct(@RequestBody InputProductDto inputProductDto, @PathVariable Integer id){
        ApiResponse apiResponse = inputProductService.editInputProduct(inputProductDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * DELETE InputProduct
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteInputProduct(@PathVariable Integer id){
        ApiResponse apiResponse = inputProductService.deleteInputProduct(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
