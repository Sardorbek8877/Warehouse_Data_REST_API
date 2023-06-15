package com.example.warehouse_data_rest_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String code;

    private boolean active;

    @OneToOne
    private Attachment attachment;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Measurement measurement;
}
