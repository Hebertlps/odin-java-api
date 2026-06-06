package com.fiap.odin.controller;

import com.fiap.odin.dto.AlertaDTO;
import com.fiap.odin.model.Alerta;
import com.fiap.odin.service.AlertaService;
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
@RequestMapping(value = "/api/alertas", name = "alertas")
@Tag(name = "Alertas", description = "Histórico de riscos iminentes")
@CrossOrigin(origins = "*")
public class AlertaController {

    @Autowired
    private AlertaService service;

    @GetMapping
    @Operation(summary = "Listar todos os alertas com paginação")
    public ResponseEntity<Page<Alerta>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar alerta por ID")
    public ResponseEntity<Alerta> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo alerta")
    public ResponseEntity<Alerta> save(@Valid @RequestBody AlertaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar alerta existente")
    public ResponseEntity<Alerta> update(@PathVariable Long id, @Valid @RequestBody AlertaDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover alerta")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
