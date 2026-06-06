package com.fiap.odin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * DTO para criacao e atualizacao de registros de auditoria.
 * Alinhado com a tabela T_GS_AUDITORIA do SQL Oracle.
 */
public record AuditoriaDTO(
    Long operadorId,

    LocalDateTime dataAcao,

    @NotBlank(message = "Tipo de acao e obrigatorio")
    String tipoAcao,

    String detalhes
) {}
