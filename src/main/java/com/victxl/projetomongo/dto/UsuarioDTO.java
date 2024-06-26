package com.victxl.projetomongo.dto;

import com.victxl.projetomongo.domain.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private String email;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
