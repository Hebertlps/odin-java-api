package com.fiap.odin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record OperadorDTO(
    @NotBlank(message = "Nome é obrigatório")
    String nome,
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,
    
    @NotBlank(message = "Senha é obrigatória")
    String senhaHash,
    
    @NotBlank(message = "Tipo de acesso é obrigatório")
    String tipoAcesso,
    
    @NotNull(message = "Data de contratação é obrigatória")
    LocalDate dataContratacao
) {}
