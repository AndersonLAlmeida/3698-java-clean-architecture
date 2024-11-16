package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;


/*
* O Factory method é um padrão de projeto de criação que lida com a criação de objetos
* sem especificar a classe exata do objeto que será criado. Em vez disso, ele define uma
* interface para criar objetos, mas permite que as subclasses alterem o tipo de objetos que serão criados.
* Isso é útil quando você quer delegar a criação de objetos para subclasses ou quando você não
* sabe antecipadamente o tipo exato de objetos que serão necessários.
* */

/*
*O Builder é usado para construir um objeto complexo passo a passo. Ele permite que você
* produza diferentes tipos e representações de um objeto usando o mesmo código de construção.
* Geralmente, ele é usado quando o construtor de um objeto tem muitos parâmetros opcionais
* ou quando a criação de um objeto envolve várias etapas complicadas.
* */

//Padrão Builder
//Não é o padrão Factory
public class FabricaDeUsuario {
    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento, Integer idade) {
        this.usuario = new Usuario(cpf, nome, nascimento, "", idade);
        return this.usuario;
    }

    public Usuario incluirEndereco(String cep, Integer numero, String complemento) {
        this.usuario.setEndereco(new Endereco(cep, numero, complemento));
        return this.usuario;
    }
}
