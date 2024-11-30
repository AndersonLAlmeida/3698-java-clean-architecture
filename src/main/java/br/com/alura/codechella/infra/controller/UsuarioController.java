package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.AlteraUsuario;
import br.com.alura.codechella.application.usecases.CriaUsuario;
import br.com.alura.codechella.application.usecases.ListaUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriaUsuario criaUsuario;
    private final AlteraUsuario alteraUsuario;
    private final ListaUsuario listaUsuario;

    public UsuarioController(CriaUsuario criaUsuario, AlteraUsuario alteraUsuario, ListaUsuario listaUsuario) {
        this.criaUsuario = criaUsuario;
        this.alteraUsuario = alteraUsuario;
        this.listaUsuario = listaUsuario;
    }


    //O ideal é retornar um DTO (Data Transfer object)
    //Também pode separar em UsuarioResquest e UsuarioResponse
    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario usuarioSalvo = criaUsuario.cadastrarUsuario(new Usuario(
                dto.cpf(),
                dto.nome(),
                dto.nascimento(),
                dto.email(), 18));

        return new UsuarioDto(
                usuarioSalvo.getCpf(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getNascimento(),
                usuarioSalvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return listaUsuario.listarTodos().stream()
                .map(usuario -> new UsuarioDto(
                        usuario.getCpf(),
                        usuario.getNome(),
                        usuario.getNascimento(),
                        usuario.getEmail()) )
                .collect(Collectors.toList());
    }

    @PutMapping
    public UsuarioDto alterarDadosUsuario(@RequestBody UsuarioDto dto) {
        Usuario usuarioAtualizado = alteraUsuario.alteraDadosUsuario(new Usuario(
                dto.cpf(),
                dto.nome(),
                dto.nascimento(),
                dto.email(), 18));

        return new UsuarioDto(
                usuarioAtualizado.getCpf(),
                usuarioAtualizado.getNome(),
                usuarioAtualizado.getNascimento(),
                usuarioAtualizado.getEmail());
    }
}
