package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;


public class CrudUsuarioImpl implements CrudUsuario {
    //Por ser final somos obrigados a passar no construtor
    private final RepositorioDeUsuario repositorio;

    public CrudUsuarioImpl(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        return repositorio.cadastrarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return List.of();
    }

    @Override
    public Usuario alteraDadosUsuario(Usuario usuario) {
        return null;
    }


}
