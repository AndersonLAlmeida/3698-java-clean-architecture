package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper entityMapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper entityMapper) {
        this.repositorio = repositorio;
        this.entityMapper = entityMapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = entityMapper.toEntity(usuario);
        entity = repositorio.save(entity);
        return entityMapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll().stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario alteraUsuario(String cpf, String email) {
        UsuarioEntity entity = repositorio.findByCpf(cpf);
        entity.setEmail(email);
        repositorio.save(entity);
        return entityMapper.toDomain(entity);
    }
}
