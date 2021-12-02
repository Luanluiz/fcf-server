package com.fcfadmin.fcf.controller.FinanceiroController;

import com.fcfadmin.fcf.model.Caixa;
import com.fcfadmin.fcf.repository.CaixaRepository;
import com.fcfadmin.fcf.wrapper.DashBoardCaixa;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/api/caixa") public class CaixaController {

    private final CaixaRepository caixaRepository;

    public CaixaController(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    @RequestMapping("/lista") public List<Caixa> buscarLista() {
        return caixaRepository.findAll();
    }

    @RequestMapping("/saldo") public BigDecimal saldoCaixa() {
        BigDecimal saldo = BigDecimal.ZERO;
        for (Caixa caixa : this.caixaRepository.findAll()) {
            if (caixa.getEntrada().compareTo(BigDecimal.ZERO) > 0) {
                saldo = saldo.add(caixa.getEntrada());
            } else {
                saldo = saldo.subtract(caixa.getSaida());
            }
        }
        return saldo;
    }

    @RequestMapping("/caixa/{id}") public Caixa buscarPorId(@PathVariable Long id) {
        return caixaRepository.findById(id).orElse(null);
    }

    @RequestMapping("/dashboard-caixa")
    public DashBoardCaixa dadosGraficos() {

        DashBoardCaixa dashBoardCaixa = new DashBoardCaixa();
        dashBoardCaixa.setReceber(this.complementaMes(caixaRepository.dadosReceber()));
        dashBoardCaixa.setPagar(this.complementaMes(caixaRepository.dadospagar()));
        dashBoardCaixa.setSaldo(this.complementaMes(caixaRepository.saldo()));

        return dashBoardCaixa;
    }

    private  Map<Integer, BigDecimal> complementaMes(List<Object[]> dados) {
        Map<Integer, BigDecimal> map = new HashMap<>();
        for (Object[] dado : dados) {

            int mes = (Integer) dado[1];
            BigDecimal valor = (BigDecimal) dado[2];
            map.put(mes, valor);
        }
        for (int i = 1; i <= 12; i++) {
            if (!map.containsKey(i)) {
                map.put(i, BigDecimal.ZERO);
            }
        }

        return map;
    }
}
