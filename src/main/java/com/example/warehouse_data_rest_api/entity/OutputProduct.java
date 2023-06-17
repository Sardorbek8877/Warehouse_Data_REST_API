package com.example.warehouse_data_rest_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OutputProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String amount;

    private String price;

    @OneToOne
    private Client client;

    @ManyToOne
    private Product product;

    @OneToOne
    private Output output;
}
