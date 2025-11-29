package com.techlab.api_tienda.controller;

import com.techlab.api_tienda.dto.LoginRequest;
import com.techlab.api_tienda.model.Usuario;
import com.techlab.api_tienda.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen (CORS)
public class UsuarioController {

    private final UsuarioService service;
    // Constructor inyectando el servicio de usuarios
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Endpoint para listar todos los usuarios
    // GET /usuarios
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    // Endpoint para login de usuarios
    // POST /usuarios/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Usuario usuario = service.login(request.user, request.password);

        if (usuario == null) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        usuario.setPassword(null); // No enviar la contraseña en la respuesta
        return ResponseEntity.ok(usuario);
    }

    // Endpoint para registrar un nuevo usuario (No se ha usado)
    // POST /usuarios/registrar
    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return service.registrar(usuario);
    }
}
