package com.fcfadmin.fcf.repository;

import com.fcfadmin.fcf.model.Entidade;
import com.fcfadmin.fcf.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("from Usuario where usuario = ?1 and senha = ?2")
    public Usuario buscarLogin(String user, String pass);
}
