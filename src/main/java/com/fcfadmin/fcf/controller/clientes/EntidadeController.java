package com.fcfadmin.fcf.controller.clientes;

import com.fcfadmin.fcf.model.Entidade;
import com.fcfadmin.fcf.repository.EntidadeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/entidades")
public class EntidadeController {

    private final EntidadeRepository entidadeRepository;

    public EntidadeController(EntidadeRepository entidadeRepository) {
        this.entidadeRepository = entidadeRepository;
    }

    @RequestMapping("/listCliente")
    public List<Entidade> getAllCliente() {
        return entidadeRepository.buscarListaCliente();
    }

    @RequestMapping("/listFornecedor")
    public List<Entidade> getAllFornecedor() {
        return entidadeRepository.buscarListaFornecedor();
    }

    @RequestMapping("/listEntidades")
    public List<Entidade> getAllEntidades() {
        return entidadeRepository.findAll();
    }

    @RequestMapping("/entidade/{id}")
    public Entidade buscarPorid(@PathVariable Long id) {
        return entidadeRepository.findById(id).get();
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public Entidade salvar(@RequestBody Entidade entidade) {
        return entidadeRepository.save(entidade);
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public void deletar(@RequestBody Entidade entidade) {
        entidadeRepository.delete(entidade);
    }

    @RequestMapping("/socios")
    public List<Entidade> buscarSocios() {
        return entidadeRepository.buscarSocios();
    }

    @RequestMapping("/total-socio")
    public int totalSocios() {
        return entidadeRepository.totalSocios();
    }
}
