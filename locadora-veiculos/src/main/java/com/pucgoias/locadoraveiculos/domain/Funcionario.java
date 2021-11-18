package com.pucgoias.locadoraveiculos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_funcionario")
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String cargo;
    private String telefone;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Aluguel> alugueis = new ArrayList<>();
}
