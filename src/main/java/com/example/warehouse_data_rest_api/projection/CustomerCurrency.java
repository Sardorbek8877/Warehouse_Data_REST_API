package com.example.warehouse_data_rest_api.projection;

import com.example.warehouse_data_rest_api.entity.Currency;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Currency.class)
public interface CustomerCurrency {

    Integer getId();

    String getName();

    boolean getActive();
}
