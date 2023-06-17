package com.example.warehouse_data_rest_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Output {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private String code;

    private String factureNumber;

    @OneToOne
    private Client client;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Currency currency;
}
