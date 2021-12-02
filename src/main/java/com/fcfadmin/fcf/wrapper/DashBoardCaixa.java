package com.fcfadmin.fcf.wrapper;

import java.math.BigDecimal;
import java.util.Map;

public class DashBoardCaixa {

    private Map<Integer, BigDecimal> receber;
    private Map<Integer, BigDecimal> pagar;
    private Map<Integer, BigDecimal> saldo;

    public Map<Integer, BigDecimal> getReceber() {
        return receber;
    }

    public void setReceber(Map<Integer, BigDecimal> receber) {
        this.receber = receber;
    }

    public Map<Integer, BigDecimal> getPagar() {
        return pagar;
    }

    public void setPagar(Map<Integer, BigDecimal> pagar) {
        this.pagar = pagar;
    }

    public Map<Integer, BigDecimal> getSaldo() {
        return saldo;
    }

    public void setSaldo(Map<Integer, BigDecimal> saldo) {
        this.saldo = saldo;
    }
}
