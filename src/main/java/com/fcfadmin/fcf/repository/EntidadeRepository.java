package com.fcfadmin.fcf.repository;

import com.fcfadmin.fcf.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntidadeRepository extends JpaRepository<Entidade, Long> {

    @Query("from Entidade where cliente = true")
    public List<Entidade> buscarListaCliente();

    @Query("from Entidade where fornecedor = true")
    public List<Entidade> buscarListaFornecedor();

    @Query("from Entidade where socio = true")
    public List<Entidade> buscarSocios();

    @Query("select count(id) from Entidade where socio = true")
    public int totalSocios();

    @Query("from Entidade where nome = ?1")
    Entidade getPorNome(String nome);
}


