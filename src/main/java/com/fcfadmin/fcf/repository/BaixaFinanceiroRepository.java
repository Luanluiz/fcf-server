package com.fcfadmin.fcf.repository;

import com.fcfadmin.fcf.model.BaixaFinanceiro;
import com.fcfadmin.fcf.model.Entidade;
import com.fcfadmin.fcf.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaixaFinanceiroRepository extends JpaRepository<BaixaFinanceiro, Long> {


}
