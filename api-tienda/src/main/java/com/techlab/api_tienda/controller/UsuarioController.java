package com.techlab.api_tienda.controller;

import com.techlab.api_tienda.dto.LoginRequest;
import com.techlab.api_tienda.model.Usuario;
import com.techlab.api_tienda.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        Usuario usuario = service.login(request.user, request.password);

        if (usuario == null) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }

        usuario.setPassword(null);
        return ResponseEntity.ok(usuario);
    }


    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return service.registrar(usuario);
    }
}
