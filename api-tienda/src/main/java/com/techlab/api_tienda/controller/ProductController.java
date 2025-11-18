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

    public ProductController(ProductService productService) {
        this.service = productService;
    }

    //POST /product
    @PostMapping("/productos")
    public Producto crearProducto( @RequestBody Producto prod) {
        return this.service.registrarProducto(prod);
    }

    //GET /products
    @GetMapping("/productos")
    public List<Producto> listarProductos(
            @RequestParam (required = false,defaultValue = "") String nombre,
            @RequestParam(required = false,defaultValue = "0") Double precio){
        return this.service.obtenerProductos(nombre,precio);
    }



    //PUT /product/1
    @PutMapping("/productos/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        return this.service.actualizarProducto(id, producto);
    }


    //DELETE /product/2
    @DeleteMapping("/productos/{id}")
    public Producto eliminarProducto(@PathVariable Long id){
        return this.service.eliminarProducto(id);
    }


}
