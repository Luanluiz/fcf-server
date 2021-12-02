package com.fcfadmin.fcf.repository;

import com.fcfadmin.fcf.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {


    @Query("select EXTRACT (YEAR FROM c.data) AS ano, " +
            "EXTRACT(MONTH FROM c.data) AS mes, "+
            "sum(c.entrada) as total "+
            "from Caixa c group by EXTRACT(YEAR FROM c.data), EXTRACT(MONTH FROM c.data) "+
            "order by mes")
    List<Object[]> dadosReceber ();

    @Query("select EXTRACT (YEAR FROM c.data) AS ano, " +
            "EXTRACT(MONTH FROM c.data) AS mes, "+
            "sum(c.saida) as total "+
            "from Caixa c group by EXTRACT(YEAR FROM c.data), EXTRACT(MONTH FROM c.data) "+
            "order by mes")
    List<Object[]> dadospagar ();

    @Query("select EXTRACT (YEAR FROM c.data) AS ano, " +
            "EXTRACT(MONTH FROM c.data) AS mes, "+
            "sum(c.entrada - c.saida) as saldo "+
            "from Caixa c group by EXTRACT(YEAR FROM c.data), EXTRACT(MONTH FROM c.data) "+
            "order by mes")
    List<Object[]> saldo ();
}
