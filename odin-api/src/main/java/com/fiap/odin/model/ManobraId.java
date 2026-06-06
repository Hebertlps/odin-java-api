package com.fiap.odin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Classe que representa uma chave composta para a entidade Manobra.
 * Implementa a interface Serializable e usa @Embeddable para ser usada como @EmbeddedId.
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManobraId implements Serializable {

    @Column(name = "ID_SATELITE", nullable = false)
    private Long idSatelite;

    @Column(name = "ID_OPERADOR", nullable = false)
    private Long idOperador;

    @Column(name = "DT_MANOBRA", nullable = false)
    private LocalDateTime dataManobra;
}
