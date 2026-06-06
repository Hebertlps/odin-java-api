package com.fiap.odin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ManobraDTO(
    @NotNull(message = "ID do satélite é obrigatório")
    Long sateliteId,
    
    @NotNull(message = "ID do operador é obrigatório")
    Long operadorId,
    
    @NotBlank(message = "Tipo de manobra é obrigatório")
    String tipoManobra,
    
    @NotNull(message = "Combustível consumido é obrigatório")
    @Positive(message = "Combustível consumido deve ser positivo")
    Double combustivelConsumido,
    
    @NotBlank(message = "Resultado é obrigatório")
    String resultado,
    
    String descricao
) {}
