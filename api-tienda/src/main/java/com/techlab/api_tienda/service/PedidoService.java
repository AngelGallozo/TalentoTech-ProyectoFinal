package com.techlab.api_tienda.service;

import com.techlab.api_tienda.dto.PedidoRequest;
import com.techlab.api_tienda.dto.PedidoResponse;
import com.techlab.api_tienda.model.Pedido;
import com.techlab.api_tienda.model.PedidoItem;
import com.techlab.api_tienda.model.Producto;
import com.techlab.api_tienda.repository.PedidoRepository;
import com.techlab.api_tienda.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepo;
    private final ProductRepository productoRepo;

    public PedidoService(PedidoRepository pedidoRepo, ProductRepository productoRepo) {
        this.pedidoRepo = pedidoRepo;
        this.productoRepo = productoRepo;
    }

    public Pedido crearPedido(PedidoRequest request) {

        // 1. Verificar stock
        for (PedidoRequest.Item item : request.getProductos()) {

            Producto producto = productoRepo.findById(item.getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.getId()));

            if (producto.getStock() < item.getCantidad()) {
                throw new RuntimeException("Sin stock suficiente para: " + producto.getTitle());
            }
        }

        // 2. Descontar stock
        for (PedidoRequest.Item item : request.getProductos()) {
            Producto producto = productoRepo.findById(item.getId()).get();
            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepo.save(producto);
        }

        // 3. Crear el pedido
        Pedido pedido = new Pedido();
        pedido.setUser(request.getUser());
        pedido.setFecha(LocalDateTime.now());

        List<PedidoItem> items = new ArrayList<>();
        for (PedidoRequest.Item item : request.getProductos()) {
            PedidoItem pi = new PedidoItem();
            pi.setProductoId(item.getId());
            pi.setCantidad(item.getCantidad());
            pi.setPedido(pedido);
            items.add(pi);
        }

        pedido.setItems(items);

        // 4. Guardar pedido con items
        return pedidoRepo.save(pedido);
    }

    public List<PedidoResponse> obtenerPedidosDeUsuario(Long userID) {
        List<Pedido> pedidos = pedidoRepo.findByUser(userID);
        List<PedidoResponse> response = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            PedidoResponse pr = new PedidoResponse();
            pr.setId(pedido.getId());
            pr.setFecha(pedido.getFecha().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

            List<PedidoResponse.Item> itemsResp = new ArrayList<>();
            double total = 0;

            for (PedidoItem pi : pedido.getItems()) {
                Producto producto = productoRepo.findById(pi.getProductoId())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + pi.getProductoId()));

                PedidoResponse.Item item = new PedidoResponse.Item();
                item.setNombreProducto(producto.getTitle());
                item.setCantidad(pi.getCantidad());
                item.setSubtotal(pi.getCantidad() * producto.getPrice());
                itemsResp.add(item);

                total += item.getSubtotal();
            }

            pr.setItems(itemsResp);
            pr.setTotal(total);

            response.add(pr);
        }

        return response;
    }

    public void eliminarPedido(Long pedidoId) {
        Pedido pedido = pedidoRepo.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado: " + pedidoId));

        // Restaurar stock de los productos
        for (PedidoItem item : pedido.getItems()) {
            Producto producto = productoRepo.findById(item.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + item.getProductoId()));
            producto.setStock(producto.getStock() + item.getCantidad());
            productoRepo.save(producto);
        }

        pedidoRepo.delete(pedido);
    }



}
