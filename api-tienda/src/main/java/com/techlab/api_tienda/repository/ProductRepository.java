package com.techlab.api_tienda.repository;

import com.techlab.api_tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long > {
    List<Producto> searchByNombre(String nombre);

    List<Producto> searchByNombreContaining(String nombre);
    List<Producto> searchByPrecioLessThanEqual(Double precio);

    List<Producto> searchByNombreContainingAndPrecioLessThanEqual(String nombre, Double precio);

}
