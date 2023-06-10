package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Measurement;
import com.example.warehouse_data_rest_api.projection.CustomerMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "measurement", collectionResourceRel = "MeasurementList", excerptProjection = CustomerMeasurement.class)
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
