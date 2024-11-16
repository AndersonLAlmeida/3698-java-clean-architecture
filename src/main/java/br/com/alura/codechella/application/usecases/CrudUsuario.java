package br.com.alura.codechella.application.usecases;


import br.com.alura.codechella.domain.entities.usuario.Usuario;

//"Puristas" do Clean Arch criam uma interface por ação. Ex: save, update, list, etc...
public interface CrudUsuario {
    Usuario cadastrarUsuario(Usuario usuario);
}
