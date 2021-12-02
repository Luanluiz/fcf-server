package com.fcfadmin.fcf.controller.FinanceiroController;

import com.fcfadmin.fcf.model.BaixaFinanceiro;
import com.fcfadmin.fcf.model.Caixa;
import com.fcfadmin.fcf.model.Financeiro;
import com.fcfadmin.fcf.model.enuns.TipoMovimentoCaixa;
import com.fcfadmin.fcf.repository.BaixaFinanceiroRepository;
import com.fcfadmin.fcf.repository.CaixaRepository;
import com.fcfadmin.fcf.repository.FinanceiroRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/baixa")
public class BaixaFinanceiroController {

    private final BaixaFinanceiroRepository baixaFinanceiroRepository;
    private final FinanceiroRepository financeiroRepository;
    private final CaixaRepository caixaRepository;

    public BaixaFinanceiroController(BaixaFinanceiroRepository baixaFinanceiroRepository, FinanceiroRepository financeiroRepository, CaixaRepository caixaRepository) {
        this.baixaFinanceiroRepository = baixaFinanceiroRepository;
        this.financeiroRepository = financeiroRepository;
        this.caixaRepository = caixaRepository;

    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public void baixar(@RequestBody BaixaFinanceiro baixa) throws Exception {

        Financeiro financeiro = financeiroRepository.findById(baixa.getIdFinanceiro()).orElse(null);
        if (financeiro != null) {
            if (baixa.getValor().compareTo(financeiro.getValor()) != 0) {
                throw new Exception("Não é permitido baixa parcial. Informa o valor inteiro do documento");
            }
    
            financeiro.setStatus("Quitado");
            financeiroRepository.save(financeiro);

            baixa.setDataBaixa(LocalDate.now());
            baixa = baixaFinanceiroRepository.save(baixa);

            TipoMovimentoCaixa tipo = TipoMovimentoCaixa.ENTRADA;
            if (financeiro.getTipo().equalsIgnoreCase("P")) {
                tipo = TipoMovimentoCaixa.SAIDA;
            }
            Caixa caixa = new Caixa();
            caixa.setTipoMovimento(tipo);
            caixa.setEntrada(tipo.equals(TipoMovimentoCaixa.ENTRADA) ? baixa.getValor() : BigDecimal.ZERO);
            caixa.setSaida(tipo.equals(TipoMovimentoCaixa.SAIDA) ? baixa.getValor() : BigDecimal.ZERO);
            caixa.setIdBaixa(baixa.getId());
            caixa.setData(baixa.getDataBaixa());
            caixa.setHistorico("Documento: " + financeiro.getDocumento());
            caixa.setMeioPagamento(baixa.getMeioPagamento());

            this.caixaRepository.save(caixa);
        }
    }
}
