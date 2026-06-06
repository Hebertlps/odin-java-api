package com.fiap.odin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "T_GS_OPERADORES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OPERADOR")
    private Long id;

    @Column(name = "NM_OPERADOR", nullable = false, length = 100)
    private String nome;

    @Column(name = "DS_EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "DS_SENHA_HASH", nullable = false, length = 255)
    private String senhaHash;

    @Column(name = "TP_ACESSO", nullable = false, length = 50)
    private String tipoAcesso;

    @Column(name = "DT_CONTRATACAO", nullable = false)
    private LocalDate dataContratacao;
}
