package com.example.labpi1.funcionario;

import com.example.labpi1.departamento.Departamento;
import jakarta.persistence.*;

@Entity
@Table
public class Funcionario {
    @Id
    @SequenceGenerator(
            name = "funcionario_sequence",
            sequenceName = "funcionario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "funcionario_sequence"
    )
    private Long id;
    private String name;
    private Float salario;
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Funcionario() {
    }

    public Funcionario(String name, Float salario, Departamento departamento) {
        this.name = name;
        this.departamento =departamento;
        this.salario = salario;
    }
}
