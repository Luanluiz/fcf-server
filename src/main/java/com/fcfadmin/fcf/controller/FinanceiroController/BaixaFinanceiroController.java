package com.fcfadmin.fcf.controller.FinanceiroController;

import com.fcfadmin.fcf.model.BaixaFinanceiro;
import com.fcfadmin.fcf.model.Financeiro;
import com.fcfadmin.fcf.repository.BaixaFinanceiroRepository;
import com.fcfadmin.fcf.repository.FinanceiroRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baixa")
public class BaixaFinanceiroController {

    private final BaixaFinanceiroRepository baixaFinanceiroRepository;
    private final FinanceiroRepository financeiroRepository;

    public BaixaFinanceiroController(BaixaFinanceiroRepository baixaFinanceiroRepository, FinanceiroRepository financeiroRepository) {
        this.baixaFinanceiroRepository = baixaFinanceiroRepository;
        this.financeiroRepository = financeiroRepository;
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public void baixar(@RequestBody BaixaFinanceiro baixa) throws Exception {

        Financeiro financeiro = financeiroRepository.findById(baixa.getIdFinanceiro()).get();
        if (baixa.getValor().compareTo(financeiro.getValor()) != 0) {
            throw new Exception("Não é permitido baixa parcial. Informa o valor inteiro do documento");
        }

        financeiro.setStatus("Quitado");
        financeiroRepository.save(financeiro);
        baixaFinanceiroRepository.save(baixa);
    }
}
