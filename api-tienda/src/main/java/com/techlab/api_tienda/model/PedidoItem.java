package com.techlab.api_tienda.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
@Table(name = "pedido_items")
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID autogenerado del item

    private Long productoId; // ID del producto asociado
    private int cantidad; // Cantidad de este producto en el pedido

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonBackReference // Maneja la relación bidireccional para evitar ciclos en JSON
    private Pedido pedido; // Pedido al que pertenece este item

}
