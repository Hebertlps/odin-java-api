package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * Subclasse de AuditoriaBase para auditoria de satélites.
 * Utiliza herança de entidades (SINGLE_TABLE strategy).
 */
@Entity
@DiscriminatorValue("SATELITE")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriaSatelite extends AuditoriaBase {

    @Column(name = "ID_SATELITE_AUDITADO")
    private Long idSateliteAuditado;

    @Column(name = "STATUS_ANTERIOR", length = 50)
    private String statusAnterior;

    @Column(name = "STATUS_NOVO", length = 50)
    private String statusNovo;
}
