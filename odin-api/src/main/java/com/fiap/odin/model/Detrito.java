package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "T_GS_DETRITOS_ESPACIAIS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETRITO")
    private Long id;

    @Column(name = "NM_DETRITO", nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "TP_DETRITO", nullable = false, length = 50)
    private String tipo;

    @Embedded
    private CoordenadaOrbital coordenada;

    @Column(name = "VL_TAMANHO_ESTIMADO", nullable = false, precision = 5, scale = 2)
    private Double tamanhoEstimado;

    @Column(name = "DT_CATALOGACAO", nullable = false)
    private LocalDate dataCatalogacao;
}
