package com.database.Entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "Tarefas")
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador")
    private Long id;

    private String nome;

    private LocalTime tempoComeco;

    private boolean estaPresente;

    private boolean provaCompleta;



    //Id, não acho que precisa de set
    public Long getId() {
        return id;
    }



    //Nome
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    //cpf
    public LocalTime getTempoComeco() {
        return tempoComeco;
    }

    public void setTempoComeco(LocalTime tempoComeco) {
        this.tempoComeco = tempoComeco;
    }

    //Presencia
    public boolean isEstaPresente() {
        return estaPresente;
    }

    public void setEstaPresente(boolean estaPresente) {
        this.estaPresente = estaPresente;
    }

    //Conclusao
    public boolean isProvaCompleta() {
        return provaCompleta;
    }

    public void setProvaCompleta(boolean provaCompleta) {
        this.provaCompleta = provaCompleta;
    }
}
