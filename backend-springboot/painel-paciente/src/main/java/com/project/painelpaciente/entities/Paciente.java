package com.project.painelpaciente.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "pacientes", schema = "public")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome",nullable = false)
    @NotEmpty(message="O nome deverá ser informado!")
    @Length(min=3, max = 200, message="O nome deverá ter entre 3 a 200 caracteres!")
    private String nome;

    @Column(name = "cpf", nullable = false)
    @NotEmpty(message="O CPF do paciente deverá ser informado!")
    private String cpf;

    @Column(name = "dataNascimento",nullable =false)
    @NotEmpty(message="A data de nascimento do paciente deverá ser informada!")
    private String dataNascimento;

    @Column(name = "telefone", nullable = false)
    @NotEmpty(message = "O numero de telefone deve ser informado!")
    private String telefone;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "O email do paciente deve ser informado!")
    private String email;

    @Column(name = "sintomas",nullable = false)
    @NotEmpty(message="Os sintomas do paciente não foram informados!")
    private String sintomas;

    @Column(name = "dataEntrada",nullable = false) //Atributo a ser preenchido automaticamente pelo sistema, com a hora de data de entrada no atendimento.
    private String dataEntrada;

    // @Column(name = "idMedicoResponsavel",nullable = false)
    // private long idMedicoResponsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    // public long getIdMedicoResponsavel() {
    //     return idMedicoResponsavel;
    // }

    // public void setIdMedicoResponsavel(long idMedicoResponsavel) {
    //     this.idMedicoResponsavel = idMedicoResponsavel;
    // }
}
