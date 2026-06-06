package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "T_GS_SATELITES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Satelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SATELITE")
    private Long id;

    @Column(name = "NM_SATELITE", nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "VL_COMBUSTIVEL_ATUAL", nullable = false, precision = 5, scale = 2)
    private Double combustivelAtual;

    @Column(name = "ST_OPERACIONAL", nullable = false, length = 50)
    private String statusOperacional;

    @Embedded
    private CoordenadaOrbital coordenada;

    @Column(name = "DT_LANCAMENTO", nullable = false)
    private LocalDate dataLancamento;
}
