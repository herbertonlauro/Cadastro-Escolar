package br.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "pessoa")
public abstract class Pessoa {

    @Id
    protected Long id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected String telefone;
    protected String endereco;
    protected int idade;

}
