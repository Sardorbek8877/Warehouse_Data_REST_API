package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Supplier;
import com.example.warehouse_data_rest_api.projection.CustomerSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "supplier", collectionResourceRel = "SupplierList", excerptProjection = CustomerSupplier.class)
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
