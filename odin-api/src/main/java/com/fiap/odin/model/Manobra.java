package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidade que representa uma manobra evasiva realizada em um satélite.
 * Mapeada para a tabela T_GS_MANOBRAS conforme SQL Oracle.
 */
@Entity
@Table(name = "T_GS_MANOBRAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manobra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MANOBRA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_SATELITE", nullable = false)
    private Satelite satelite;

    @ManyToOne
    @JoinColumn(name = "ID_OPERADOR", nullable = false)
    private Operador operador;

    @Column(name = "DT_MANOBRA", nullable = false)
    private LocalDateTime dataManobra = LocalDateTime.now();

    @Column(name = "TP_MANOBRA", nullable = false, length = 50)
    private String tipoManobra;

    @Column(name = "VL_COMBUSTIVEL_CONSUMIDO", nullable = false)
    private Double combustivelConsumido;

    @Column(name = "ST_RESULTADO", nullable = false, length = 50)
    private String resultado;

    @Column(name = "DS_MANOBRA", length = 500)
    private String descricao;
}
