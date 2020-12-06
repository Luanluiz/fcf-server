package com.fcfadmin.fcf.controller.usuarios;

import com.fcfadmin.fcf.model.Entidade;
import com.fcfadmin.fcf.model.Financeiro;
import com.fcfadmin.fcf.model.Usuario;
import com.fcfadmin.fcf.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RequestMapping("/listUsuario")
    public List<Usuario> getAllUSuario() {
        return usuarioRepository.findAll().stream().filter(user -> !user.getUsuario().equals("1") && user.getId() != 28L).collect(Collectors.toList());
    }

    @RequestMapping("/usuario/{id}")
    public Usuario buscarPorid(@PathVariable Long id) {
        return usuarioRepository.findById(id).get();
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public Usuario salvar(@RequestBody Usuario entidade) {
        return usuarioRepository.save(entidade);
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public void deletar(@RequestBody Usuario entidade) {
        usuarioRepository.delete(entidade);
    }

    @RequestMapping("/login")
    public boolean login(@RequestParam String usuario, @RequestParam String senha) {
        return usuarioRepository.buscarLogin(usuario, senha) != null;
    }
}
