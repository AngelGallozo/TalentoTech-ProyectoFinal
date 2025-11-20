package com.techlab.api_tienda.service;

import com.techlab.api_tienda.model.Producto;
import com.techlab.api_tienda.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository){
        this.repository = productRepository;
    }

    public List<Producto> obtenerProductos(String title, Double priceMax){

        // FILTRO: title + price
        if (!title.isEmpty() && priceMax > 0){
            return this.repository.findByTitleContainingAndPriceLessThanEqual(title, priceMax);
        }

        // FILTRO: title
        if (!title.isEmpty()){
            return this.repository.findByTitleContaining(title);
        }

        // FILTRO: price
        if (priceMax > 0){
            return this.repository.findByPriceLessThanEqual(priceMax);
        }

        // Sin filtros
        return this.repository.findAll();
    }

    public Producto registrarProducto(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto data) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // title
        if (data.getTitle() != null && !data.getTitle().isBlank()) {
            producto.setTitle(data.getTitle());
        }

        // price
        if (data.getPrice() != null && data.getPrice() > 0) {
            producto.setPrice(data.getPrice());
        }

        // description
        if (data.getDescription() != null) {
            producto.setDescription(data.getDescription());
        }

        // category
        if (data.getCategory() != null) {
            producto.setCategory(data.getCategory());
        }

        // image
        if (data.getImage() != null) {
            producto.setImage(data.getImage());
        }

        // rating
        if (data.getRating() != null) {
            if (data.getRating().getRate() != null) {
                producto.getRating().setRate(data.getRating().getRate());
            }
            if (data.getRating().getCount() != null) {
                producto.getRating().setCount(data.getRating().getCount());
            }
        }

        return repository.save(producto);
    }

    public Producto eliminarProducto(Long id){
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        repository.delete(producto);
        return producto;
    }
}
