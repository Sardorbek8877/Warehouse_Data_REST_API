package com.example.warehouse_data_rest_api.controller;

import com.example.warehouse_data_rest_api.entity.Warehouse;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.WarehouseDto;
import com.example.warehouse_data_rest_api.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    /**
     * GET Warehouses
     * @return List<Warehouse>
     */
    @GetMapping
    public ResponseEntity<List<Warehouse>> getWarehouses(){
        List<Warehouse> warehouses = warehouseService.getWarehouses();
        return ResponseEntity.ok(warehouses);
    }

    /**
     * GET WarehouseById
     * @param id
     * @return Warehouse
     */
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Integer id){
        Warehouse warehouseById = warehouseService.getWarehouseById(id);
        return ResponseEntity.ok(warehouseById);
    }

    /**
     * ADD Warehouse
     * @param warehouseDto
     * @return ApiResponse
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addWarehouse(@RequestBody WarehouseDto warehouseDto){
        ApiResponse apiResponse = warehouseService.addWarehouse(warehouseDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * EDIT Warehouse
     * @param warehouseDto
     * @param id
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editWarehouse(@RequestBody WarehouseDto warehouseDto, @PathVariable Integer id){
        ApiResponse apiResponse = warehouseService.editWarehouse(warehouseDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * DELETE Warehouse
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteWarehouse(@PathVariable Integer id){
        ApiResponse apiResponse = warehouseService.deleteWarehouse(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

}
