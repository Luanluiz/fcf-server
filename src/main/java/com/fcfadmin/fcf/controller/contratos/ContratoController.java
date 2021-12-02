package com.fcfadmin.fcf.controller.contratos;

import com.fcfadmin.fcf.model.Contrato;
import com.fcfadmin.fcf.model.Entidade;
import com.fcfadmin.fcf.model.Financeiro;
import com.fcfadmin.fcf.repository.ContratoRepository;
import com.fcfadmin.fcf.repository.EntidadeRepository;
import com.fcfadmin.fcf.repository.FinanceiroRepository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    private final ContratoRepository contratoRepository;
    private final FinanceiroRepository financeiroRepository;
    private final EntidadeRepository entidadeRepository;

    public ContratoController(ContratoRepository contratoRepository, FinanceiroRepository financeiroRepository, EntidadeRepository entidadeRepository) {
        this.contratoRepository = contratoRepository;
        this.financeiroRepository = financeiroRepository;
        this.entidadeRepository = entidadeRepository;
    }

    @RequestMapping("/listaContrato")
    public List<Contrato> getAllContratos() {
        return contratoRepository.findAll();
    }

    @RequestMapping("/contrato/{id}")
    public Contrato buscarPorId(@PathVariable Long id) {
        return this.contratoRepository.findById(id).get();
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public Contrato salvar(@RequestBody Contrato contrato) {
        Entidade entidade = entidadeRepository.getPorNome(contrato.getNomeEntidade());
        contrato.setIdEntidade(entidade.getId());
        Contrato c = contratoRepository.save(contrato);
        LocalDate data = c.getDataInicio();
        if (c.getId() != null && c.getId() > 0L) {
            for (int i = 1; i <= contrato.getTempo(); i++) {
                Financeiro financeiro = new Financeiro();
                financeiro.setDocumento(c.getId() + "/" +i);
                financeiro.setEmissao(c.getDataInicio());
                financeiro.setStatus("Aberto");
                financeiro.setNomeEntidade(c.getNomeEntidade());
                financeiro.setIdEntidade(c.getIdEntidade());
                financeiro.setTipoDocumento("Contrato");
                financeiro.setTipo("R");
                financeiro.setValor(c.getValor());
                data = data.plusMonths(1);
                LocalDate vencimento = LocalDate.of(data.getYear(), data.getMonth() , c.getDiaVencimento());

                financeiro.setVencimento(vencimento);
                financeiro.setIdContrato(c.getId());
                this.financeiroRepository.save(financeiro);
            }
        }
        return c;
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public void deletar(@RequestBody Contrato contrato) {
        contratoRepository.delete(contrato);
    }

}
