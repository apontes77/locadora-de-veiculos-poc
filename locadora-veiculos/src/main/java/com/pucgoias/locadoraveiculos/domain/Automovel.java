package com.pucgoias.locadoraveiculos.domain;

import com.pucgoias.locadoraveiculos.domain.enums.StatusLocacao;
import com.pucgoias.locadoraveiculos.domain.enums.TipoCambio;
import com.pucgoias.locadoraveiculos.domain.enums.TipoCombustivel;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
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
    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;
    @Enumerated(EnumType.STRING)
    private TipoCambio tipoCambio;
    @Enumerated(EnumType.STRING)
    private StatusLocacao statusLocacao;
    private BigDecimal capacidadeTanque;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Aluguel> alugueis = new ArrayList<>();
}
