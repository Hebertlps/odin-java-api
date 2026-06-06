package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entidade que representa um detrito espacial.
 * Utiliza @SecondaryTable para armazenar dados adicionais em tabela secundária.
 */
@Entity
@Table(name = "T_GS_DETRITOS_ESPACIAIS")
@SecondaryTable(
    name = "T_GS_DETRITOS_ANALISE",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID_DETRITO")
)
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

    @Column(name = "VL_TAMANHO_ESTIMADO", nullable = false)
    private Double tamanhoEstimado;

    @Column(name = "DT_CATALOGACAO", nullable = false)
    private LocalDate dataCatalogacao;

    // Colunas na tabela secundária (T_GS_DETRITOS_ANALISE)
    @Column(name = "RISCO_COLISAO", table = "T_GS_DETRITOS_ANALISE", length = 50)
    private String riscoColisao;

    @Column(name = "VELOCIDADE_RELATIVA", table = "T_GS_DETRITOS_ANALISE")
    private Double velocidadeRelativa;

    @Column(name = "PROXIMIDADE_SATELITES", table = "T_GS_DETRITOS_ANALISE")
    private Double proximidadeSatelites;

    @Column(name = "DT_ULTIMA_ANALISE", table = "T_GS_DETRITOS_ANALISE")
    private LocalDate dataUltimaAnalise;
}
