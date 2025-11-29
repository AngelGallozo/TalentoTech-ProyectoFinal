package com.techlab.api_tienda.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoResponse {

    private Long id;
    private String fecha; // ya formateada como string
    private List<Item> items;
    private double total;

    @Data
    public static class Item {
        private String nombreProducto;
        private int cantidad;
        private double subtotal;
    }
}
