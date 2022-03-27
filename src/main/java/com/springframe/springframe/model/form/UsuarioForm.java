package com.springframe.springframe.model.form;

import com.springframe.springframe.model.entity.Usuario;

public class UsuarioForm {

    private String nome;
    private String senha;
    private String email;

    public UsuarioForm(Usuario usuario){
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
        this.email = usuario.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Usuario convert(){
        return new Usuario(nome, email, senha, false);
    }
}
