package com.fiap.odin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlertaDTO(
    @NotNull(message = "ID do satélite é obrigatório")
    Long sateliteId,
    
    @NotNull(message = "ID do detrito é obrigatório")
    Long detritoId,
    
    @NotBlank(message = "Severidade é obrigatória")
    String severidade,
    
    String descricao,
    
    @NotBlank(message = "Status é obrigatório")
    String status
) {}
