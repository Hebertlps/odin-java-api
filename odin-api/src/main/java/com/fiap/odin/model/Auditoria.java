package com.fiap.odin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * Entidade que representa um registro de auditoria geral do sistema.
 * Herda de AuditoriaBase utilizando herança de entidades (SINGLE_TABLE strategy).
 */
@Entity
@DiscriminatorValue("GERAL")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Auditoria extends AuditoriaBase {

    @ManyToOne
    @JoinColumn(name = "ID_OPERADOR")
    private Operador operador;
}
