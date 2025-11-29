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
    private Long id; // ID autogenerado del producto

    private String title; // Nombre del producto
    private Double price; // Precio del producto
    @Lob
    private String description; // Descripción detallada del producto
    private String category; // Categoría del producto
    private String image; // URL de la imagen del producto
    private Integer stock;  // Cantidad disponible en inventario

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

