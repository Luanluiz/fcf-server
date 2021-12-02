package com.fcfadmin.fcf.model;

import com.fcfadmin.fcf.model.enuns.TipoMovimentoCaixa;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    private TipoMovimentoCaixa tipoMovimento;
    @Basic
    private int tipo;
    private BigDecimal entrada;
    private BigDecimal saida;
    private Long idBaixa;
    private LocalDate data;
    private String historico;
    private String meioPagamento;

    @PrePersist
    void populateDBFields() {
        this.tipo = tipoMovimento.getId();
    }

    @PostLoad
    void populateTransientFields() {

        this.tipoMovimento = Arrays.stream(TipoMovimentoCaixa.values()).filter(t -> t.getId() == this.tipo).findFirst().orElse(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMovimentoCaixa getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimentoCaixa tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }


    public BigDecimal getEntrada() {
        return entrada;
    }

    public void setEntrada(BigDecimal entrada) {
        this.entrada = entrada;
    }

    public BigDecimal getSaida() {
        return saida;
    }

    public void setSaida(BigDecimal saida) {
        this.saida = saida;
    }

    public Long getIdBaixa() {
        return idBaixa;
    }

    public void setIdBaixa(Long idBaixa) {
        this.idBaixa = idBaixa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(String meioPagamento) {
        this.meioPagamento = meioPagamento;
    }
}
