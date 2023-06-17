package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Output;
import com.example.warehouse_data_rest_api.entity.OutputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {

}
