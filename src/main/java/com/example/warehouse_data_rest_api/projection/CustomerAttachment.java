package com.example.warehouse_data_rest_api.projection;

import com.example.warehouse_data_rest_api.entity.Attachment;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Attachment.class)
public interface CustomerAttachment {

    Integer getId();

    String getName();

    String getContentType();

    double getSize();
}
