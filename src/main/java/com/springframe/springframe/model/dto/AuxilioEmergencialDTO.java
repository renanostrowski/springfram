package com.springframe.springframe.model.dto;

import com.springframe.springframe.model.entity.AuxilioEmergencial;
import com.springframe.springframe.model.entity.Municipio;

import java.math.BigDecimal;
import java.util.Date;

public class AuxilioEmergencialDTO {

    private Long codigoAuxilio;
    private Date dataConsulta;
    private MunicipioDTO municipioDTO;
    private String numeroParcela;
    private BigDecimal valorTotal;

    public AuxilioEmergencialDTO(AuxilioEmergencial auxilioEmergencial){
        this.codigoAuxilio = auxilioEmergencial.getCodigoAuxilio();
        this.municipioDTO = new MunicipioDTO(auxilioEmergencial.getMunicipio());
        this.dataConsulta = auxilioEmergencial.getDataConsulta();
        this.numeroParcela = auxilioEmergencial.getNumeroParcela();
        this.valorTotal = auxilioEmergencial.getValorTotal();
    }

    public Long getCodigoAuxilio() {
        return codigoAuxilio;
    }

    public void setCodigoAuxilio(Long codigoAuxilio) {
        this.codigoAuxilio = codigoAuxilio;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public MunicipioDTO getMunicipioDTO() {
        return municipioDTO;
    }

    public void setMunicipioDTO(MunicipioDTO municipioDTO) {
        this.municipioDTO = municipioDTO;
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
