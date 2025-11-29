package com.techlab.api_tienda.service;

import com.techlab.api_tienda.model.Usuario;
import com.techlab.api_tienda.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario login(String user, String password) {
        return repo.findByUser(user)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }

    public Usuario registrar(Usuario usuario) {
        return repo.save(usuario);
    }

    public java.util.List<Usuario> listar() {
        return repo.findAll();
    }
}
