package com.fcfadmin.fcf.controller.FinanceiroController;

import com.fcfadmin.fcf.model.Financeiro;
import com.fcfadmin.fcf.repository.FinanceiroRepository;
import com.fcfadmin.fcf.wrapper.DadosDashboard;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController @RequestMapping("/api/financeiro") public class FinanceiroController {

    private final String STATUS_ABERTO = "Aberto";
//    private final String STATUS_QUITADO = "Quitado";

    private final String TIPO_RECEBER = "R";
    private final String TIPO_PAGAR = "P";

    private final FinanceiroRepository financeiroRepository;

    public FinanceiroController(FinanceiroRepository financeiroRepository) {
        this.financeiroRepository = financeiroRepository;
    }

    @RequestMapping("/listreceber")
    public List<Financeiro> buscarListaReceber() {
        return financeiroRepository.buscarListaReceber();
    }

    @RequestMapping("/listpagar")
    public List<Financeiro> buscarListaPagar() {
        return financeiroRepository.buscarListaPagar();
    }

    @RequestMapping("/financeiro/{id}")
    public Financeiro buscarPorid(@PathVariable Long id) {
        return financeiroRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public Financeiro salvar(@RequestBody Financeiro financeiro) {
        return financeiroRepository.save(financeiro);
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public void deletar(@RequestBody Financeiro financeiro) {
        financeiroRepository.delete(financeiro);
    }

    @RequestMapping("/receber-vencido")
    public List<Financeiro> buscarReceberVencido() {
        List<Financeiro> documentosReceberAberto = financeiroRepository.buscarDadosFinanceiro(TIPO_RECEBER, STATUS_ABERTO);
        return documentosReceberAberto.stream().filter(dado -> dado.getVencimento().compareTo(LocalDate.now()) < 0).collect(Collectors.toList());
    }

    @RequestMapping("/receber-vencendo")
    public List<Financeiro> buscarReceberVencendo() {
        List<Financeiro> documentosReceberAberto = financeiroRepository.buscarDadosFinanceiro(TIPO_RECEBER, STATUS_ABERTO);
        return documentosReceberAberto.stream().filter(dado -> dado.getVencimento().compareTo(LocalDate.now()) == 0).collect(Collectors.toList());
    }

    @RequestMapping("/pagar-vencido")
    public List<Financeiro> buscarPagarVencido() {
        List<Financeiro> documentosPagarAberto = financeiroRepository.buscarDadosFinanceiro(TIPO_PAGAR, STATUS_ABERTO);
        return documentosPagarAberto.stream().filter(dado -> dado.getVencimento().compareTo(LocalDate.now()) < 0).collect(Collectors.toList());
    }

    @RequestMapping("/pagar-vencendo")
    public List<Financeiro> buscarPagarVencendo() {
        List<Financeiro> documentosPagarAberto = financeiroRepository.buscarDadosFinanceiro(TIPO_PAGAR, STATUS_ABERTO);
        return documentosPagarAberto.stream().filter(dado -> dado.getVencimento().compareTo(LocalDate.now()) == 0).collect(Collectors.toList());
    }

    @RequestMapping("/dashboard")
    public DadosDashboard buscarDadosFinanceiro() {

        BigDecimal receberVencido = buscarReceberVencido().stream().map(Financeiro::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal receberVencendo = buscarReceberVencendo().stream().map(Financeiro::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal pagarVencido = buscarPagarVencido().stream().map(Financeiro::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal pagarVencendo = buscarPagarVencendo().stream().map(Financeiro::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);

        DadosDashboard dashboard = new DadosDashboard();
        dashboard.setValorReceberVencido(receberVencido);
        dashboard.setValorReceberVencendo(receberVencendo);
        dashboard.setValorPagarVencido(pagarVencido);
        dashboard.setValorPagarVencendo(pagarVencendo);

        return dashboard;
    }
}
