package com.techlab.api_tienda.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID autogenerado del pedido

    private Long user; // ID del usuario que realizó el pedido

    private LocalDateTime fecha; // Fecha y hora del pedido

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference // Para manejar la relación bidireccional en JSON y evitar ciclos
    private List<PedidoItem> items = new ArrayList<>(); // Lista de items asociados al pedido

}
