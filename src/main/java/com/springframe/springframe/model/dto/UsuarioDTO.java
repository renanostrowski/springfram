package com.springframe.springframe.model.dto;

import com.springframe.springframe.model.entity.Usuario;

public class UsuarioDTO {

    private Long codigoUsuario;
    private String nome;
    private String email;

    public UsuarioDTO(Usuario usuario){
        this.codigoUsuario = usuario.getCodigoUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
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
