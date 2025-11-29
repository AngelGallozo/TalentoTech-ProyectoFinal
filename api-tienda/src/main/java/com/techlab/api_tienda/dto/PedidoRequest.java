package com.techlab.api_tienda.dto;

import lombok.Data;

import java.util.List;

@Data
// DTO para crear un pedido desde el cliente
public class PedidoRequest {
    private Long user; // ID del usuario que realiza el pedido
    private List<Item> productos; // Lista de productos y sus cantidades

    @Data
    // Clase interna para representar cada producto del pedido
    public static class Item {
        private Long id; // ID del producto
        private int cantidad; // Cantidad del producto en el pedido
    }
}
