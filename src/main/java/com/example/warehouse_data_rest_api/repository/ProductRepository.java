package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsByCode(String code);
}
