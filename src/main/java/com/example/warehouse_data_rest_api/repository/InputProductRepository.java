package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Input;
import com.example.warehouse_data_rest_api.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {

}
