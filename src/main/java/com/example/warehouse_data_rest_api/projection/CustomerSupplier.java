package com.example.warehouse_data_rest_api.projection;

import com.example.warehouse_data_rest_api.entity.Supplier;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Supplier.class)
public interface CustomerSupplier {

    Integer getId();

    String getName();

    String getPhoneNumber();

    boolean getActive();
}
