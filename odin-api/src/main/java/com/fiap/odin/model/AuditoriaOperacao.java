package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * Subclasse de AuditoriaBase para auditoria de operações específicas.
 * Utiliza herança de entidades (SINGLE_TABLE strategy).
 */
@Entity
@DiscriminatorValue("OPERACAO")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriaOperacao extends AuditoriaBase {

    @Column(name = "ID_OPERADOR_AUDITADO")
    private Long idOperadorAuditado;

    @Column(name = "RESULTADO_OPERACAO", length = 50)
    private String resultadoOperacao;
}
