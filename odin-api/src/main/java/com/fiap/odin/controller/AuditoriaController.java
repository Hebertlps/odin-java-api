package com.fiap.odin.controller;

import com.fiap.odin.dto.AuditoriaDTO;
import com.fiap.odin.model.Auditoria;
import com.fiap.odin.service.AuditoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auditorias")
@Tag(name = "Auditoria", description = "Rastreio de acessos e ações críticas")
@CrossOrigin(origins = "*")
public class AuditoriaController {

    @Autowired
    private AuditoriaService service;

    @GetMapping
    @Operation(summary = "Listar todas as auditorias com paginação")
    public ResponseEntity<Page<Auditoria>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar auditoria por ID")
    public ResponseEntity<Auditoria> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova auditoria")
    public ResponseEntity<Auditoria> save(@Valid @RequestBody AuditoriaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar auditoria existente")
    public ResponseEntity<Auditoria> update(@PathVariable Long id, @Valid @RequestBody AuditoriaDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover auditoria")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
