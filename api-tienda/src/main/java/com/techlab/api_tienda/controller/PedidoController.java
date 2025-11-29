package com.techlab.api_tienda.controller;

import com.techlab.api_tienda.dto.PedidoRequest;
import com.techlab.api_tienda.model.Pedido;
import com.techlab.api_tienda.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*") // Permite que cualquier origen haga peticiones (CORS)
public class PedidoController {

    private final PedidoService service;
    // Constructor inyectando el servicio de pedidos
    public PedidoController(PedidoService service) {
        this.service = service;
    }
    // Endpoint para crear un nuevo pedido
    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequest request) {
        try {
            Pedido pedido = service.crearPedido(request);
            return ResponseEntity.ok(pedido);

        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    // Endpoint para obtener todos los pedidos de un usuario
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> obtenerPedidos(@PathVariable Long userId) {
        return ResponseEntity.ok(service.obtenerPedidosDeUsuario(userId));
    }

    // Endpoint para eliminar un pedido por ID
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
