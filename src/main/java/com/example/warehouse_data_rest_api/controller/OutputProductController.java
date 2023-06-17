package com.example.warehouse_data_rest_api.controller;

import com.example.warehouse_data_rest_api.entity.Output;
import com.example.warehouse_data_rest_api.entity.OutputProduct;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.OutputDto;
import com.example.warehouse_data_rest_api.payload.OutputProductDto;
import com.example.warehouse_data_rest_api.service.OutputProductService;
import com.example.warehouse_data_rest_api.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/outputProduct")
public class OutputProductController {

    @Autowired
    OutputProductService outputProductService;

    /**
     * Get OutputProducts
     * @return List<OutputProduct>
     */
    @GetMapping
    public ResponseEntity<List<OutputProduct>> getOutputProducts(){
        List<OutputProduct> outputProducts = outputProductService.getOutputProducts();
        return ResponseEntity.ok(outputProducts);
    }

    /**
     * GET OutputProduct BY iD
     * @param id
     * @return OutputProduct
     */
    @GetMapping("/{id}")
    public ResponseEntity<OutputProduct> getOutputProduct(@PathVariable Integer id){
        OutputProduct outputProduct = outputProductService.getOutputProduct(id);
        return ResponseEntity.ok(outputProduct);
    }

    /**
     * ADD OutputProduct
     * @param outputProductDto
     * @return ApiResponse
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addOutputProduct(@RequestBody OutputProductDto outputProductDto){
        ApiResponse apiResponse = outputProductService.addOutputProduct(outputProductDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * EDIT OutputProduct
     * @param outputProductDto
     * @param id
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editOutputProduct(@RequestBody OutputProductDto outputProductDto, @PathVariable Integer id){
        ApiResponse apiResponse = outputProductService.editOutputProduct(outputProductDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * DELETE OutputProduct
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteOutputProduct(@PathVariable Integer id){
        ApiResponse apiResponse = outputProductService.deleteOutputProduct(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
