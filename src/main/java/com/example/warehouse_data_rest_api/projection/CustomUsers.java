package com.example.warehouse_data_rest_api.projection;

import com.example.warehouse_data_rest_api.entity.Users;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Users.class)
public interface CustomUsers {

    Integer getId();

    String getFirstName();

    String getLastName();

    String getPhoneNumber();

    String getCode();

    String getPassword();

    boolean getActive();
}
