package com.example.labpi1.departamento;

import jakarta.persistence.*;

@Entity
@Table
public class Departamento {
    @Id
    @SequenceGenerator(
            name = "departamento_sequence",
            sequenceName = "departamento_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "departamento_sequence"
    )
    private Long id;
    private String nome;


    public Departamento() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Departamento(String nome) {
        this.nome = nome;

    }
}
