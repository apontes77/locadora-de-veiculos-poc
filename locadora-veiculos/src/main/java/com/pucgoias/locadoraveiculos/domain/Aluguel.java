package com.pucgoias.locadoraveiculos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluguel")
    private Long id;
    @Column(name = "data_alugado")
    private LocalDate dataAlugado;
    @Column(name = "data_devolvido")
    private LocalDate dataDevolvido;
    @Column(name = "dias_contratados")
    private int diasContratados;
    @Column(name = "valor_pago")
    private BigDecimal valorPago;


}
