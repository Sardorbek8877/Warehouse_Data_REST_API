package com.example.warehouse_data_rest_api.projection;

import com.example.warehouse_data_rest_api.entity.Measurement;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Measurement.class)
public interface CustomerMeasurement {

    Integer getId();

    String getName();

    boolean getActive();
}
