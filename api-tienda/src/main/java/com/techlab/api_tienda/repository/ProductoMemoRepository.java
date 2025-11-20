package com.techlab.api_tienda.repository;

import com.techlab.api_tienda.model.Producto;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.ArrayList;

@Repository
public class ProductoMemoRepository {
    // Array principal que tendra los productos en Stock
    ArrayList<Producto> stock = new ArrayList<>();
    // Array principal que tendra los pedidos
    ArrayList<Producto> pedidos = new ArrayList<>();
    private static Long nextID=1L;

    public ProductoMemoRepository() {
        // Instanciando bebidas Default
//        stock.add(new Producto("Té Chai",45.0,20));
//        stock.add(new Producto("Té Verde",25.0,20));
//        stock.add(new Producto("Café Americano",65.0,20));
//        stock.add(new Producto("Café Negro",75.0,20));
//
//        // Instanciando Comida Default
//        stock.add(new Producto("Medialuna",65.0,50));
//        stock.add(new Producto("Gallelitas",35.0,80));

        for (Producto producto:stock){
            this.updateId(producto);
        }
    }


    // Funcion encargada de agregar el producto con los datos que nos brinda la vista en consola.
    public Producto agregarProducto(Producto producto){
        updateId(producto);
        stock.add(producto);
        return producto;
    }

    private void updateId(Producto producto){
        producto.setId(nextID);
        nextID++;
    }


    public ArrayList<Producto> obtenerProductos() {
        return this.stock;
    }

    public Producto obtenerProductoPorId(int id){
        for (Producto producto:stock){
//            if(producto.coincideId(id)){
//                return producto;
//            }
        }

        return null;
    }

    // Funcion que busca por nombre en todos los productos.
    public ArrayList<Producto> obtenerProductosPorNombre(String nombre ) {

        ArrayList<Producto> productoEncontrados = new ArrayList<>();

        for (Producto producto : this.stock) {
//            if (estaIncluido(producto.getNombre(), nombre)) {
//                productoEncontrados.add(producto);
//            }
        }

        return productoEncontrados;
    }
    // Funcion que busca por precio en todos los productos.
    public ArrayList<Producto> filtrarPorPrecioTope(double precio ) {

        ArrayList<Producto> productoFiltrados = new ArrayList<>();

        for (Producto producto : this.stock) {
//            if (producto.getPrecio()<=precio) {
//                productoFiltrados.add(producto);
//            }
        }

        return productoFiltrados;
    }

    // Funcion que busca por precio y nombre en todos los productos.
    public ArrayList<Producto> obtenerProductosPorNombreYPrecioTope(String nombre , double precioTope ) {

        ArrayList<Producto> productoFiltrados = new ArrayList<>();

        for (Producto producto : this.stock) {
//            if (producto.getPrecio()<=precioTope && estaIncluido(producto.getNombre(), nombre)) {
//                productoFiltrados.add(producto);
//            }
        }

        return productoFiltrados;
    }



    // Funcion que verifica si la el nombre esta incluido en el nombre Completo del producto
    private boolean estaIncluido(String nombreCompleto, String nombreParcial) {
        String nombreCompletoFormateado = formatoBusqueda(nombreCompleto);
        String nombreParcialFormateado = formatoBusqueda(nombreParcial);

        return nombreCompletoFormateado.contains(nombreParcialFormateado);
    }

    // Formatea cadenas de texto, quita espacios, los pone en minuscula y le quita tildes
    private String formatoBusqueda(String texto) {
        if (texto == null) return "";

        // 1. Quita espacios y pasa a minúsculas
        String resultado = texto.trim().toLowerCase();

        // 2. Normaliza el texto para quitar acentos
        resultado = Normalizer.normalize(resultado, Normalizer.Form.NFD);
        resultado = resultado.replaceAll("\\p{M}", ""); // elimina marcas diacríticas (acentos)

        // 3. Quita signos de puntuación
        resultado = resultado.replaceAll("[\\p{Punct}]", "");

        return resultado;
    }




    public void actualizarProducto(Producto producto){
        System.out.println("Se actualizó el producto con id "+producto.getId());
    }

    public Producto eliminarProducto(Producto producto) {
        this.stock.remove(producto);
        return producto;
    }


}
