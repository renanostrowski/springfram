package com.springframe.springframe.model.form;

import com.springframe.springframe.model.entity.Municipio;
import com.springframe.springframe.model.entity.UnidadeFederativa;

public class MunicipioForm {

    private Long codigoIBGE;
    private String nomeIBGE;
    private String codigoRegiao;
    private String pais;
    private UnidadeFederativaForm unidadeFederativaForm;

    public MunicipioForm(Municipio municipio){
        this.codigoIBGE = municipio.getCodigoIBGE();
        this.nomeIBGE = municipio.getNomeIBGE();
        this.codigoRegiao = municipio.getCodigoRegiao();
        this.pais = municipio.getPais();
        this.unidadeFederativaForm = new UnidadeFederativaForm(municipio.getUnidadeFederativa());
    }

    public Long getCodigoIBGE() {
        return codigoIBGE;
    }

    public UnidadeFederativaForm getUnidadeFederativaForm() {
        return unidadeFederativaForm;
    }

    public void setUnidadeFederativaForm(UnidadeFederativaForm unidadeFederativaForm) {
        this.unidadeFederativaForm = unidadeFederativaForm;
    }

    public void setCodigoIBGE(Long codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }

    public String getNomeIBGE() {
        return nomeIBGE;
    }

    public void setNomeIBGE(String nomeIBGE) {
        this.nomeIBGE = nomeIBGE;
    }

    public String getCodigoRegiao() {
        return codigoRegiao;
    }

    public void setCodigoRegiao(String codigoRegiao) {
        this.codigoRegiao = codigoRegiao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
