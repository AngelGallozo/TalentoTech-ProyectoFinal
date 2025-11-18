package com.techlab.api_tienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nom, double prec, int cant){
        this.nombre = nom;
        this.precio = prec;
        this.cantidad = cant;
    }

    public Producto(){
    }



    // Verifica si el id buscado es el del objeto
    public boolean coincideId(int id) {
        return this.id == id;
    }
}