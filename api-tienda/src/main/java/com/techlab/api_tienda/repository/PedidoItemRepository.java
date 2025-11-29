package com.techlab.api_tienda.repository;

import com.techlab.api_tienda.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {}
