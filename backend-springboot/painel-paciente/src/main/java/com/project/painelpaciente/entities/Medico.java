package com.project.painelpaciente.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "medicos", schema = "public")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome", nullable = false)
    @NotEmpty(message = "O nome deverá ser informado!")
    private String nome;

    @Column(name = "especialidade", nullable = false)
    @NotEmpty(message = "A especialidade deverá ser informada!")
    private String especialidade;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "O email deverá ser informado!")
    private String email;

    @Column(name = "username", nullable = false)
    @NotEmpty(message = "O username deverá ser informado!")
    private String username;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
