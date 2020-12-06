package com.fcfadmin.fcf.repository;

import com.fcfadmin.fcf.model.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {

    @Query("from Financeiro where tipo = 'R' order by status")
    List<Financeiro> buscarListaReceber();

    @Query("from Financeiro where tipo = 'P' order by status")
    List<Financeiro> buscarListaPagar();
}
