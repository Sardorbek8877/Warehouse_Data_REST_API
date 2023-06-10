package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Currency;
import com.example.warehouse_data_rest_api.projection.CustomerCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "currency", collectionResourceRel = "CurrencyList", excerptProjection = CustomerCurrency.class)
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
