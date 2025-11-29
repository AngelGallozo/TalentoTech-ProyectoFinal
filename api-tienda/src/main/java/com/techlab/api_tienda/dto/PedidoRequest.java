package com.techlab.api_tienda.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoRequest {
    private Long user;
    private List<Item> productos;

    @Data
    public static class Item {
        private Long id;
        private int cantidad;
    }
}
