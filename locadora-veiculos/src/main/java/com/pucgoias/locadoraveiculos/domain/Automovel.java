package com.pucgoias.locadoraveiculos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_automovel")
    private Long id;
    @Column(name = "valor_dia_aluguel")
    private BigDecimal valorDiaAluguel;
    private String placa;
    private String marca;
    private String modelo;
    private String capacidadePessoa;
    @Column(name = "tamanho_portamala")
    private String tamanhoPortaMala;
    private String tipoCombustivel;
    private String tipoCambio;
    private String statusLocacao;
    private BigDecimal capacidadeTanque;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Aluguel> alugueis = new ArrayList<>();
}
