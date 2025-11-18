package com.techlab.api_tienda.service;

import com.techlab.api_tienda.model.Producto;
import com.techlab.api_tienda.repository.ProductRepository;
import com.techlab.api_tienda.repository.ProductoMemoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //private ProductoMemoRepository repository;
    private ProductRepository repository;

    public ProductService(ProductRepository productRepository){
        this.repository= productRepository;
    }

    public List<Producto> obtenerProductos(String nombre, Double precioTope){

        if (!nombre.isEmpty() && precioTope > 0){
            return this.repository.searchByNombreContainingAndPrecioLessThanEqual(nombre,precioTope);
        }

        if (!nombre.isEmpty() ){
            return this.repository.searchByNombreContaining(nombre);
        }

        if (precioTope > 0){
            return this.repository.searchByPrecioLessThanEqual(precioTope);
        }

        return this.repository.findAll();
    }




    public Producto actualizarProducto(Long id, Producto data) {
        Producto producto = this.repository.findById(id).
                orElseThrow(()-> new RuntimeException("No encontramos el producto."));

        if (data.getNombre() != null && !data.getNombre().isBlank()) {
            producto.setNombre(data.getNombre());
        }else{
            System.out.println("No se pudo editar el producto. Nombre no valido.");
        }

        if (data.getPrecio() > 0) {
            producto.setPrecio(data.getPrecio());
        }else{
            System.out.println("No se pudo editar el producto. Precio no valido.");
        }

        repository.save(producto);
        return producto;
    }


    public Producto eliminarProducto(Long id){
        Optional<Producto> productoOptional = this.repository.findById(id);
        if (productoOptional.isEmpty()) {
            System.out.println("No se pudo eliminar el producto. No se encontró el producto");
            return null;
        }
        Producto producto = productoOptional.get();
        this.repository.delete(producto);
        System.out.println("Se elimino el producto con id: "+producto.getId());
        return producto;
    }

    public Producto registrarProducto(Producto prd) {
        return this.repository.save(prd);
    }



}
