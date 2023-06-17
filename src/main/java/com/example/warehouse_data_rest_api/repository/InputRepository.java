package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input, Integer> {

}
