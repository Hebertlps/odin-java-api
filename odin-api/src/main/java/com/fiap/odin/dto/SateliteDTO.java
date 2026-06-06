package com.fiap.odin.dto;

import com.fiap.odin.model.CoordenadaOrbital;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public record SateliteDTO(
    @NotBlank(message = "Nome é obrigatório")
    String nome,
    
    @NotNull(message = "Combustível atual é obrigatório")
    @PositiveOrZero(message = "Combustível não pode ser negativo")
    Double combustivelAtual,
    
    @NotBlank(message = "Status operacional é obrigatório")
    String statusOperacional,
    
    @NotNull(message = "Coordenadas são obrigatórias")
    CoordenadaOrbital coordenada,
    
    @NotNull(message = "Data de lançamento é obrigatória")
    LocalDate dataLancamento
) {}
