package com.techlab.api_tienda.controller;

import com.techlab.api_tienda.dto.PedidoRequest;
import com.techlab.api_tienda.model.Pedido;
import com.techlab.api_tienda.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequest request) {
        try {
            Pedido pedido = service.crearPedido(request);
            return ResponseEntity.ok(pedido);

        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> obtenerPedidos(@PathVariable Long userId) {
        return ResponseEntity.ok(service.obtenerPedidosDeUsuario(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Long id) {
        try {
            service.eliminarPedido(id);
            return ResponseEntity.ok(Map.of("message", "Pedido eliminado"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }



}
