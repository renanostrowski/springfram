package com.springframe.springframe.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class AuxilioEmergencial {
    public AuxilioEmergencial(){};

    public AuxilioEmergencial(Date dataConsulta, Municipio municipio, String numeroParcela, BigDecimal valorTotal){
        this.dataConsulta = dataConsulta;
        this.municipio = municipio;
        this.numeroParcela = numeroParcela;
        this.valorTotal = valorTotal;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_aux_emerg")
    private Long codigoAuxilio;

    @Column(name = "dataConsulta")
    private Date dataConsulta;

    @ManyToOne
    @JoinColumn(name = "codigoMunicipio")
    private Municipio municipio;

    @Column(name = "numeroParcela")
    private String numeroParcela;

    @Column(name = "valorTotal")
    private BigDecimal valorTotal;

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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
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
