package com.pucgoias.locadoraveiculos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorDiaAluguel;
    private String placa;
    private String marca;
    private String modelo;
    private String capacidadePessoa;
    private String tamanhoPortaMala;
    private String tipoCombustivel;
    private String tipoCambio;
    private String statusLocacao;
    private BigDecimal capacidadeTanque;
}
