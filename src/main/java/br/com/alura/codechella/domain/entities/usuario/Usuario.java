package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;
/*
* As entidades (entities) representam os objetos principais do domínio da aplicação.
* Elas têm identidade própria e são mutáveis, o que significa que as mudanças em seus atributos
* refletem mudanças no estado do sistema. As entidades são geralmente associadas a conceitos do
* domínio que têm vida útil longa e são distinguidos por suas características únicas.
* */

//Entidade: Classe que possui uma identidade/identificado único (algo diferencia entre dois usuario)
//Regras de domínio
public class Usuario {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Endereco endereco;
    private Integer idade;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario(String cpf, String nome, LocalDate nascimento, String email, Integer idade) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw  new IllegalArgumentException("Cpf no padrão incorreto");
        }

        if (idade < 18) {
            throw new IllegalArgumentException("Usuario menor de 18 anos nao podem ser cadastrados");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }



    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
