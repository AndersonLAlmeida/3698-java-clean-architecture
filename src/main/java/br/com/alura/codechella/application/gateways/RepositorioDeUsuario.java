package br.com.alura.codechella.application.gateways;


import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

//"Puristas" do Clean Arch criam uma interface por ação. Ex: save, update, list, etc...
public interface RepositorioDeUsuario {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario alteraUsuario(String cpf, String email);
}
