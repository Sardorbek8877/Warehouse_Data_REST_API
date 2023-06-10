package com.example.warehouse_data_rest_api.projection;

import com.example.warehouse_data_rest_api.entity.Client;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Client.class)
public interface CustomerClient {

    Integer getId();

    String getName();

    String getPhoneNumber();
}
