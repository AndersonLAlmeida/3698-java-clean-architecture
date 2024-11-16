package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CrudUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CrudUsuario crudUsuario;

    public UsuarioController(CrudUsuario crudUsuario) {
        this.crudUsuario = crudUsuario;
    }

    //O ideal é retornar um DTO (Data Transfer object)
    //Também pode separar em UsuarioResquest e UsuarioResponse
    @PostMapping
    public UsuarioDto cadastrarUsuario(UsuarioDto dto) {
        Usuario usuarioSalvo = crudUsuario.cadastrarUsuario(new Usuario(
                dto.cpf(),
                dto.nome(),
                dto.nascimento(),
                dto.email(), dto.nascimento().lengthOfYear()));

        return new UsuarioDto(
                usuarioSalvo.getCpf(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getNascimento(),
                usuarioSalvo.getEmail());
    }
}
