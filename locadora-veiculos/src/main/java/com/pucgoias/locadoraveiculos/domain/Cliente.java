package com.pucgoias.locadoraveiculos.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String endereco;
    private String telefone;
    private String cartaoCredito;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Aluguel> alugueis = new ArrayList<>();
}
