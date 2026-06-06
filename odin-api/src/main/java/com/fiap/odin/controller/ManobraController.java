package com.fiap.odin.controller;

import com.fiap.odin.dto.ManobraDTO;
import com.fiap.odin.model.Manobra;
import com.fiap.odin.service.ManobraService;
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
@RequestMapping("/api/manobras")
@Tag(name = "Manobras", description = "Log de evasões realizadas")
@CrossOrigin(origins = "*")
public class ManobraController {

    @Autowired
    private ManobraService service;

    @GetMapping
    @Operation(summary = "Listar todas as manobras com paginação")
    public ResponseEntity<Page<Manobra>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar manobra por ID")
    public ResponseEntity<Manobra> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova manobra")
    public ResponseEntity<Manobra> save(@Valid @RequestBody ManobraDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar manobra existente")
    public ResponseEntity<Manobra> update(@PathVariable Long id, @Valid @RequestBody ManobraDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover manobra")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
