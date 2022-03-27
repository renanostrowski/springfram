package com.springframe.springframe.model.dto;

import com.springframe.springframe.model.entity.UnidadeFederativa;

public class UnidadeFederativaDTO {
    private Long codigoUF;
    private String sigla;
    private String nome;

    public UnidadeFederativaDTO(UnidadeFederativa unidadeFederativa){
        this.codigoUF = unidadeFederativa.getCodigoUF();
        this.nome = unidadeFederativa.getNome();
        this.nome = unidadeFederativa.getNome();
    }

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
