package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    boolean existsByName(String name);
}
