package com.example.warehouse_data_rest_api.projection;

import com.example.warehouse_data_rest_api.entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface CustomerCategory {

    Integer getId();

    String getName();

    boolean getActive();
}
