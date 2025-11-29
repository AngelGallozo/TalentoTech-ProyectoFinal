package com.techlab.api_tienda.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
// DTO para enviar la información de un pedido al cliente
public class PedidoResponse {

    private Long id;           // ID del pedido
    private String fecha;      // Fecha del pedido ya formateada como string
    private List<Item> items;  // Lista de productos del pedido con cantidad y subtotal
    private double total;      // Total del pedido

    @Data
    // Clase interna para representar cada producto dentro del pedido
    public static class Item {
        private String nombreProducto; // Nombre del producto
        private int cantidad;          // Cantidad pedida de este producto
        private double subtotal;       // Subtotal de este producto (cantidad * precio)
    }
}
