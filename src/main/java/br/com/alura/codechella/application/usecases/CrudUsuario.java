package br.com.alura.codechella.application.usecases;


import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

//"Puristas" do Clean Arch criam uma interface por ação. Ex: save, update, list, etc...
public interface CrudUsuario {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario alteraDadosUsuario(Usuario usuario);
}
