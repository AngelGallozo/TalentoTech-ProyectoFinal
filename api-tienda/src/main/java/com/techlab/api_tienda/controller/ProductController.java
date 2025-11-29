package com.techlab.api_tienda.controller;

import com.techlab.api_tienda.model.Producto;
import com.techlab.api_tienda.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService service;

    // Constructor inyectando el servicio de productos
    public ProductController(ProductService productService) {
        this.service = productService;
    }

    // Endpoint para crear un nuevo producto
    // POST /productos
    @PostMapping("/productos")
    public Producto crearProducto( @RequestBody Producto prod) {
        return this.service.registrarProducto(prod);
    }

    // Endpoint para listar productos
    // GET /productos?nombre=algo
    // Permite filtrar por nombre (opcional)
    @GetMapping("/productos")
    public List<Producto> listarProductos(@RequestParam(required = false, defaultValue = "") String nombre) {
        return service.obtenerProductos(nombre);
    }

    // Endpoint para actualizar un producto existente
    // PUT /productos/{id}
    @PutMapping("/productos/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        return this.service.actualizarProducto(id, producto);
    }

    // Endpoint para eliminar un producto por ID
    // DELETE /productos/{id}
    @DeleteMapping("/productos/{id}")
    public Producto eliminarProducto(@PathVariable Long id){
        return this.service.eliminarProducto(id);
    }


}
