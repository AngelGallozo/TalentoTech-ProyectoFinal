package com.techlab.api_tienda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;
    private String password;
    private String type; // admin o user

    public Usuario() {}

    public Usuario(String user, String password, String type) {
        this.user = user;
        this.password = password;
        this.type = type;
    }
}
