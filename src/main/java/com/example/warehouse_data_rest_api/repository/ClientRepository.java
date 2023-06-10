package com.example.warehouse_data_rest_api.repository;

import com.example.warehouse_data_rest_api.entity.Client;
import com.example.warehouse_data_rest_api.projection.CustomerClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "client", collectionResourceRel = "ClientsList", excerptProjection = CustomerClient.class)
public interface ClientRepository extends JpaRepository<Client, Integer> {


}
