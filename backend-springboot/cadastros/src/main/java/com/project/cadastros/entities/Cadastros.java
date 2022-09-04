package com.project.cadastros.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cadastros", schema = "public")
public class Cadastros {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email" ,nullable = false)
    private String email;

    @Column(name= "senha", nullable = false)
    private String senha;

    @Column(name= "data_nascimento", nullable = false)
    private String data_nascimento;

    @Column(name= "telefone", nullable = false)
    private String telefone;

    @Column(name= "tipo_pessoa", nullable = false)
    private String tipo_pessoa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String dataNascimento) {
        this.data_nascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipoPessoa) {
        this.tipo_pessoa = tipoPessoa;
    }

    
}
