# Tienda Online - Proyecto Final TalentoTech2025

Este proyecto es una **tienda online** desarrollado como trabajo final para el programa **TalentoTech2025**.  
La aplicación backend está implementada con **Java Spring Boot** y conecta con **MySQL** para la gestión de usuarios, productos y pedidos.

## Características principales

- Gestión de **productos**:
    - Crear, listar, actualizar y eliminar productos.
    - Manejo de stock, categoría, descripción, imagen y ratings.
    - Búsqueda de productos por nombre y filtrado por precio.
- Gestión de **pedidos**:
    - Crear pedidos con múltiples productos.
    - Listar pedidos por usuario.
    - Eliminar pedidos.

- **API RESTful** con endpoints claros para usuarios, productos y pedidos.
- Soporte **CORS** para integración con frontend externo.
- Base de datos MySQL con inicialización de datos y relaciones entre tablas (`usuarios`, `productos`, `pedidos`, `pedido_items`).
- DTOs para comunicación segura y clara entre frontend y backend.
- Feedback y manejo de errores en respuestas de la API.

## Credenciales de acceso (para pruebas)

| Tipo de usuario | Usuario | Contraseña |
| --------------- | ------- | ---------- |
| Usuario normal  | user1   | 1234       |
| Administrador   | admin   | 1234       |
