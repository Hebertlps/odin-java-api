package com.fiap.odin.dto;

import com.fiap.odin.model.CoordenadaOrbital;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public record DetritoDTO(
    @NotBlank(message = "Nome é obrigatório")
    String nome,
    
    @NotBlank(message = "Tipo é obrigatório")
    String tipo,
    
    @NotNull(message = "Coordenadas são obrigatórias")
    CoordenadaOrbital coordenada,
    
    @NotNull(message = "Tamanho estimado é obrigatório")
    @Positive(message = "Tamanho deve ser positivo")
    Double tamanhoEstimado,
    
    @NotNull(message = "Data de catalogação é obrigatória")
    LocalDate dataCatalogacao
) {}
