package com.crud.domain;

public class Aluno {
    private String id;
    private String nome;
    private String sobrenome;
    private int matricula;

    public Aluno(){

    }

    public Aluno(String id, String nome, String sobrenome, int matricula) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}




