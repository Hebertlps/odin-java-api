package com.fiap.odin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

/**
 * DTO para criacao e atualizacao de manobras evasivas.
 * Alinhado com a tabela T_GS_MANOBRAS do SQL Oracle.
 */
public record ManobraDTO(
    @NotNull(message = "ID do satelite e obrigatorio")
    Long sateliteId,

    @NotNull(message = "ID do operador e obrigatorio")
    Long operadorId,

    LocalDateTime dataManobra,

    @NotBlank(message = "Tipo de manobra e obrigatorio")
    String tipoManobra,

    @NotNull(message = "Combustivel consumido e obrigatorio")
    @Positive(message = "Combustivel consumido deve ser positivo")
    Double combustivelConsumido,

    @NotBlank(message = "Resultado e obrigatorio")
    String resultado,

    String descricao
) {}
