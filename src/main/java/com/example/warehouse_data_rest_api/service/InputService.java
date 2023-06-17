package com.example.warehouse_data_rest_api.service;

import com.example.warehouse_data_rest_api.entity.*;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.InputDto;
import com.example.warehouse_data_rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    SupplierRepository supplierRepository;

    /**
     * Get Inputs
     * @return List<Input>
     */
    public List<Input> getInputs(){
        return inputRepository.findAll();
    }

    /**
     * GET Input BY iD
     * @param id
     * @return Input
     */
    public Input getInput(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        return optionalInput.orElse(null);
    }

    /**
     * ADD Input
     * @param inputDto
     * @return ApiResponse
     */
    public ApiResponse addInput(InputDto inputDto){

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("Warehouse not found", false);
        Warehouse warehouse = optionalWarehouse.get();

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (optionalCurrency.isEmpty())
            return new ApiResponse("Currency not found", false);
        Currency currency = optionalCurrency.get();

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (optionalSupplier.isEmpty())
            return new ApiResponse("Supplier not found", false);
        Supplier supplier = optionalSupplier.get();

        Input input = new Input();
        input.setDate(inputDto.getDate());
        input.setCode(inputDto.getCode());
        input.setSupplier(supplier);
        input.setCurrency(currency);
        input.setWarehouse(warehouse);
        input.setFactureNumber(inputDto.getFactureNumber());
        return new ApiResponse("Input added", true);
    }

    /**
     * EDIT Input
     * @param inputDto
     * @param id
     * @return ApiResponse
     */
    public ApiResponse editInput(InputDto inputDto, Integer id) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (optionalInput.isEmpty())
            return new ApiResponse("Input not found", false);
        Input input = optionalInput.get();

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("Input not found", false);
        Warehouse warehouse = optionalWarehouse.get();

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (optionalCurrency.isEmpty())
            return new ApiResponse("Currency not found", false);
        Currency currency = optionalCurrency.get();

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (optionalSupplier.isEmpty())
            return new ApiResponse("Supplier not found", false);
        Supplier supplier = optionalSupplier.get();

        input.setDate(inputDto.getDate());
        input.setCode(inputDto.getCode());
        input.setSupplier(supplier);
        input.setCurrency(currency);
        input.setWarehouse(warehouse);
        input.setFactureNumber(inputDto.getFactureNumber());
        return new ApiResponse("Input edited", true);
    }

    /**
     * DELETE Input
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteInput(Integer id){
        try {
            inputRepository.deleteById(id);
            return new ApiResponse("Input deleted", true);
        }
        catch (Exception e){
            return new ApiResponse("Input not found", false);
        }
    }
}
