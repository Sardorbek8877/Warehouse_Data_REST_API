package com.example.warehouse_data_rest_api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputProductDto {

    private Date expireDate;

    private String amount;

    private double price;

    private Integer productId;

    private Integer inputId;
}
