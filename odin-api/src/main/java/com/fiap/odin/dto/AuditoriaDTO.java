package com.fiap.odin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuditoriaDTO(
    @NotNull(message = "ID do operador é obrigatório")
    Long operadorId,
    
    @NotBlank(message = "Tipo de ação é obrigatório")
    String tipoAcao,
    
    String detalhes,
    
    String nomeUsuario
) {}
