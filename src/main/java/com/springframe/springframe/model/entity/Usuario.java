package com.springframe.springframe.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    public Usuario(String nome, String email, String senha, Boolean adm){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.adm = adm;
    }

    public Usuario() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_usuario")
    private Long codigoUsuario;

    @NotBlank(message = "Nome do usuário deve ser informado!")
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "Senha deve ser informada!")
    @Column(name = "senha")
    private String senha;

    @NotBlank(message = "E-mail dev ser informado!")
    @Column(name = "email")
    private String email;

    @Column(name = "adm")
    private Boolean adm = false;

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

    public Boolean getAdm() {
        return adm;
    }

    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
