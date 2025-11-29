package com.techlab.api_tienda.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.techlab.api_tienda.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUser(String user);
}
