package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioEntityTest {

    @Test
    void naoDeveCadastrarComCpfInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Usuario("123456789-99", "teste", LocalDate.parse("1997-01-28"), "email@email.com", 19));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Usuario("12345678999", "teste", LocalDate.parse("1997-01-28"), "email@email.com", 17));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Usuario("123.456.78999", "teste", LocalDate.parse("1997-01-28"), "email@email.com", 20));
    }

    @Test
    void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabricaDeUsuario = new FabricaDeUsuario();
        Usuario usuario = fabricaDeUsuario.comNomeCpfNascimento(
                "Anderson",
                "123.456.789-06",
                LocalDate.parse("1997-01-28"),
                18);

        Assertions.assertEquals(usuario.getNome(), "Anderson");

        usuario = fabricaDeUsuario.incluirEndereco("18654-098", 123, "");

        Assertions.assertEquals(123, usuario.getEndereco().getNumero());
    }

    @Test
    void naoDeveCadastrarUsuarioMenorDe18Anos() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Usuario(
                        "123.456.789-99",
                        "teste",
                        LocalDate.parse("1997-01-28"),
                        "email@email.com",
                        17));

        Assertions.assertEquals("Usuario menor de 18 anos nao podem ser cadastrados", exception.getMessage());
    }


}
