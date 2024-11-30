package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListaUsuario {
    //Por ser final somos obrigados a passar no construtor
    private final RepositorioDeUsuario repositorio;

    public ListaUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> listarTodos() {
        return repositorio.listarTodos();
    }
}
