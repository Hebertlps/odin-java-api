package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Classe base para auditoria usando herança de entidades (SINGLE_TABLE strategy).
 * Esta classe é a superclasse para diferentes tipos de auditoria no sistema.
 */
@Entity
@Table(name = "T_GS_AUDITORIA_BASE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TP_AUDITORIA", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriaBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AUDITORIA")
    private Long id;

    @Column(name = "DT_EVENTO", nullable = false)
    private LocalDateTime dataEvento = LocalDateTime.now();

    @Column(name = "NM_USUARIO", nullable = false, length = 100)
    private String nomeUsuario;

    @Column(name = "TP_OPERACAO", nullable = false, length = 50)
    private String tipoOperacao;

    @Column(name = "DS_DETALHES", length = 1000)
    private String detalhes;
}
