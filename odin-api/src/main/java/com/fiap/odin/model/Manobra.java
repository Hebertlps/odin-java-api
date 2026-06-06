package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidade que representa uma manobra realizada em um satélite.
 * Utiliza chave composta (@EmbeddedId) para identificação única.
 */
@Entity
@Table(name = "T_GS_MANOBRAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manobra {

    @EmbeddedId
    private ManobraId id;

    @ManyToOne
    @JoinColumn(name = "ID_SATELITE", nullable = false, insertable = false, updatable = false)
    private Satelite satelite;

    @ManyToOne
    @JoinColumn(name = "ID_OPERADOR", nullable = false, insertable = false, updatable = false)
    private Operador operador;

    @Column(name = "TP_MANOBRA", nullable = false, length = 50)
    private String tipoManobra;

    @Column(name = "VL_COMBUSTIVEL_CONSUMIDO", nullable = false)
    private Double combustivelConsumido;

    @Column(name = "ST_RESULTADO", nullable = false, length = 50)
    private String resultado;

    @Column(name = "DS_MANOBRA", length = 500)
    private String descricao;
}
