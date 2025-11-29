package com.techlab.api_tienda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double price;
    @Lob
    private String description;
    private String category;
    private String image;
    private Integer stock;

    @Embedded
    private Rating rating;

    public Producto() {}

    public Producto(String title, Double price, String description, String category, String image, Rating rating,Integer stock){
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
        this.stock = stock;
    }
}

