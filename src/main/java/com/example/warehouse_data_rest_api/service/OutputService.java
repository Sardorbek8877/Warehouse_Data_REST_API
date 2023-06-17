package com.example.warehouse_data_rest_api.service;

import com.example.warehouse_data_rest_api.entity.*;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.OutputDto;
import com.example.warehouse_data_rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputService {

    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ClientRepository clientRepository;

    /**
     * Get Outputs
     * @return List<Output>
     */
    public List<Output> getOutputs(){
        return outputRepository.findAll();
    }

    /**
     * GET Output BY iD
     * @param id
     * @return Output
     */
    public Output getOutput(Integer id){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        return optionalOutput.orElse(null);
    }

    /**
     * ADD Output
     * @param outputDto
     * @return ApiResponse
     */
    public ApiResponse addOutput(OutputDto outputDto){

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("Output not found", false);
        Warehouse warehouse = optionalWarehouse.get();

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (optionalCurrency.isEmpty())
            return new ApiResponse("Currency not found", false);
        Currency currency = optionalCurrency.get();

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (optionalClient.isEmpty())
            return new ApiResponse("Client not found", false);
        Client client = optionalClient.get();

        Output output = new Output();
        output.setDate(outputDto.getDate());
        output.setCode(outputDto.getCode());
        output.setClient(client);
        output.setCurrency(currency);
        output.setWarehouse(warehouse);
        output.setFactureNumber(outputDto.getFactureNumber());
        return new ApiResponse("Output added", true);
    }

    /**
     * EDIT Output
     * @param outputDto
     * @param id
     * @return ApiResponse
     */
    public ApiResponse editOutput(OutputDto outputDto, Integer id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (optionalOutput.isEmpty())
            return new ApiResponse("Output not found", false);
        Output output = optionalOutput.get();

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("Output not found", false);
        Warehouse warehouse = optionalWarehouse.get();

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (optionalCurrency.isEmpty())
            return new ApiResponse("Currency not found", false);
        Currency currency = optionalCurrency.get();

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        if (optionalClient.isEmpty())
            return new ApiResponse("Client not found", false);
        Client client = optionalClient.get();

        output.setDate(outputDto.getDate());
        output.setCode(outputDto.getCode());
        output.setClient(client);
        output.setCurrency(currency);
        output.setWarehouse(warehouse);
        output.setFactureNumber(outputDto.getFactureNumber());
        return new ApiResponse("Output edited", true);
    }

    /**
     * DELETE Output
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteOutput(Integer id){
        try {
            outputRepository.deleteById(id);
            return new ApiResponse("Output deleted", true);
        }
        catch (Exception e){
            return new ApiResponse("Output not found", false);
        }
    }
}
