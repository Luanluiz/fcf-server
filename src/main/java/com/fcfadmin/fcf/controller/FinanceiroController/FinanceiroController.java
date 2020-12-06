package com.fcfadmin.fcf.controller.FinanceiroController;

import com.fcfadmin.fcf.model.Financeiro;
import com.fcfadmin.fcf.repository.FinanceiroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

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
        return financeiroRepository.findById(id).get();
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public Financeiro salvar(@RequestBody Financeiro financeiro) {
        return financeiroRepository.save(financeiro);
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public void deletar(@RequestBody Financeiro financeiro) {
        financeiroRepository.delete(financeiro);
    }
}
