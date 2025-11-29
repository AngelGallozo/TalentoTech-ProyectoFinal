package com.techlab.api_tienda.repository;

import com.techlab.api_tienda.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUser(Long user);
}

