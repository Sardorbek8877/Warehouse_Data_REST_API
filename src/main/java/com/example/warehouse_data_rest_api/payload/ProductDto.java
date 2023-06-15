package com.example.warehouse_data_rest_api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;

    private String code;

    private boolean active;

    private Integer attachmentId;

    private Integer categoryId;

    private Integer measurementId;
}
