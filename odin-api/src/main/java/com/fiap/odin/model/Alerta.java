package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "T_GS_ALERTAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALERTA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_SATELITE", nullable = false)
    private Satelite satelite;

    @ManyToOne
    @JoinColumn(name = "ID_DETRITO", nullable = false)
    private Detrito detrito;

    @Column(name = "DT_ALERTA", nullable = false)
    private LocalDateTime dataAlerta = LocalDateTime.now();

    @Column(name = "ST_SEVERIDADE", nullable = false, length = 20)
    private String severidade;

    @Column(name = "DS_ALERTA", length = 500)
    private String descricao;

    @Column(name = "ST_ALERTA", nullable = false, length = 20)
    private String status;
}
