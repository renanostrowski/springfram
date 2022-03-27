package com.springframe.springframe.model.form;


import com.springframe.springframe.model.entity.AuxilioEmergencial;

import java.math.BigDecimal;

public class AuxilioEmergencialForm {

    private MunicipioForm municipioForm;
    private String numeroParcela;
    private BigDecimal valorTotal;

    public AuxilioEmergencialForm(AuxilioEmergencial auxilioEmergencial){
        this.municipioForm = new MunicipioForm(auxilioEmergencial.getMunicipio());
        this.numeroParcela = auxilioEmergencial.getNumeroParcela();
        this.valorTotal = auxilioEmergencial.getValorTotal();
    }

    public MunicipioForm getMunicipioForm() {
        return municipioForm;
    }

    public void setMunicipioForm(MunicipioForm municipioForm) {
        this.municipioForm = municipioForm;
    }

    public String getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(String numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
