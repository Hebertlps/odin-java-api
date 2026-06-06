package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Entidade que representa um registro de auditoria do sistema.
 * Mapeada para a tabela T_GS_AUDITORIA conforme SQL Oracle.
 */
@Entity
@Table(name = "T_GS_AUDITORIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AUDITORIA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_OPERADOR")
    private Operador operador;

    @Column(name = "DT_ACAO", nullable = false)
    private LocalDateTime dataAcao = LocalDateTime.now();

    @Column(name = "TP_ACAO", nullable = false, length = 50)
    private String tipoAcao;

    @Column(name = "DS_DETALHES", length = 1000)
    private String detalhes;
}
