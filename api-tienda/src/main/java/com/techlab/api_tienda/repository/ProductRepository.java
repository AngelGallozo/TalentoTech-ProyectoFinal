package com.techlab.api_tienda.repository;

import com.techlab.api_tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByTitleContaining(String title);

    List<Producto> findByPriceLessThanEqual(Double price);

    List<Producto> findByTitleContainingAndPriceLessThanEqual(String title, Double price);
}