package com.fcfadmin.fcf.wrapper;

import java.math.BigDecimal;

public class DadosDashboard {

    private BigDecimal valorReceberVencido;
    private BigDecimal valorReceberVencendo;
    private BigDecimal valorPagarVencido;
    private BigDecimal valorPagarVencendo;
    private BigDecimal totalSocios;

    public BigDecimal getValorReceberVencido() {
        return valorReceberVencido;
    }

    public void setValorReceberVencido(BigDecimal valorReceberVencido) {
        this.valorReceberVencido = valorReceberVencido;
    }

    public BigDecimal getValorReceberVencendo() {
        return valorReceberVencendo;
    }

    public void setValorReceberVencendo(BigDecimal valorReceberVencendo) {
        this.valorReceberVencendo = valorReceberVencendo;
    }

    public BigDecimal getValorPagarVencido() {
        return valorPagarVencido;
    }

    public void setValorPagarVencido(BigDecimal valorPagarVencido) {
        this.valorPagarVencido = valorPagarVencido;
    }

    public BigDecimal getValorPagarVencendo() {
        return valorPagarVencendo;
    }

    public void setValorPagarVencendo(BigDecimal valorPagarVencendo) {
        this.valorPagarVencendo = valorPagarVencendo;
    }

    public BigDecimal getTotalSocios() {
        return totalSocios;
    }

    public void setTotalSocios(BigDecimal totalSocios) {
        this.totalSocios = totalSocios;
    }
}
