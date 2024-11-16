package br.com.alura.codechella.domain;

/*
* Os objetos de valor (value objects) representam valores que são importantes para o domínio da aplicação,
* mas não têm identidade própria. Eles são imutáveis, ou seja, uma vez criados, seus valores não podem
* ser alterados. Os objetos de valor são geralmente usados para modelar conceitos do domínio que são
* definidos exclusivamente por seus atributos, sem identidade distinta.
* */
//Value Object: Não vai na classe/package de entidade e é caracterizado por PODER HAVER o mesmo endereço para
//mais de um Usuario e não há um identificador único que os diferencie
public class Endereco {
    private String cep;

    public String getCep() {
        return cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    private Integer numero;
    private String complemento;

    public Endereco(String cep, Integer numero, String complemento) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }
}
