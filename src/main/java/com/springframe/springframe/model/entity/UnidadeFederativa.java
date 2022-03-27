package com.springframe.springframe.model.entity;

import javax.persistence.*;

@Entity
public class UnidadeFederativa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_uf")
    private Long codigoUF;

    @Column(name = "sigla", length = 2)
    private String sigla;

    @Column(name = "nome")
    private String nome;

    public Long getCodigoUF() {
        return codigoUF;
    }

    public void setCodigoUF(Long codigoUF) {
        this.codigoUF = codigoUF;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
