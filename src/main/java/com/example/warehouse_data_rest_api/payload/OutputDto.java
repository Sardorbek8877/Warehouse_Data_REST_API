package com.example.warehouse_data_rest_api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputDto {

    private Date date;

    private String code;

    private String factureNumber;

    private Integer clientId;

    private Integer warehouseId;

    private Integer currencyId;
}
