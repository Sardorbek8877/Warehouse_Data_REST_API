package com.example.warehouse_data_rest_api.service;

import com.example.warehouse_data_rest_api.entity.Users;
import com.example.warehouse_data_rest_api.entity.Warehouse;
import com.example.warehouse_data_rest_api.payload.ApiResponse;
import com.example.warehouse_data_rest_api.payload.WarehouseDto;
import com.example.warehouse_data_rest_api.repository.UsersRepository;
import com.example.warehouse_data_rest_api.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    UsersRepository usersRepository;

    /**
     * GET Warehouses
     * @return List<Warehouse>
     */
    public List<Warehouse> getWarehouses(){return warehouseRepository.findAll();}

    /**
     * GET WarehouseById
     * @param id
     * @return Warehouse
     */
    public Warehouse getWarehouseById(Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        return optionalWarehouse.orElse(null);
    }

    /**
     * ADD Warehouse
     * @param warehouseDto
     * @return ApiResponse
     */
    public ApiResponse addWarehouse(WarehouseDto warehouseDto){
        boolean existsByName = warehouseRepository.existsByName(warehouseDto.getName());
        if (existsByName)
            return new ApiResponse("Name already exist", false);

        List<Users> usersList = new ArrayList<>();
        List<Integer> usersId = warehouseDto.getUsersId();
        for (Integer id:usersId ) {
            Optional<Users> optionalUsers = usersRepository.findById(id);
            if (optionalUsers.isEmpty())
                return new ApiResponse("User not found", false);
            Users user = optionalUsers.get();
            usersList.add(user);
        }

        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseDto.getName());
        warehouse.setActive(warehouseDto.isActive());
        warehouse.setUsersList(usersList);
        warehouseRepository.save(warehouse);
        return new ApiResponse("Warehouse added", true);
    }

    /**
     * EDIT Warehouse
     * @param warehouseDto
     * @param id
     * @return ApiResponse
     */
    public ApiResponse editWarehouse(WarehouseDto warehouseDto, Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("Warehouse not found", false);

        Warehouse warehouse = optionalWarehouse.get();

        boolean existsByName = warehouseRepository.existsByName(warehouseDto.getName());
        if (existsByName)
            return new ApiResponse("Name already exist", false);

        List<Users> usersList = new ArrayList<>();
        List<Integer> usersId = warehouseDto.getUsersId();
        for (Integer idUser:usersId ) {
            Optional<Users> optionalUsers = usersRepository.findById(idUser);
            if (optionalUsers.isEmpty())
                return new ApiResponse("User not found", false);
            Users user = optionalUsers.get();
            usersList.add(user);
        }

        warehouse.setName(warehouseDto.getName());
        warehouse.setActive(warehouseDto.isActive());
        warehouse.setUsersList(usersList);
        warehouseRepository.save(warehouse);
        return new ApiResponse("Warehouse edited", true);
    }

    /**
     * DELETE Warehouse
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteWarehouse(Integer id){
        try {
            warehouseRepository.deleteById(id);
            return new ApiResponse("Warehouse deleted", true);
        }
        catch (Exception e){
            return new ApiResponse("Warehouse not found", false);
        }
    }
}
