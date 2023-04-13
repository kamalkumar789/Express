package com.example.Express.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Product_name")
    private String name;

    @Column(name = "Product_variant", unique = true, nullable = false)
    private String variant;

    @Column(name = "Product_price")
    private Double price;

}