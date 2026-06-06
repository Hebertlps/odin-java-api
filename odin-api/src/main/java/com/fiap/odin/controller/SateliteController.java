package com.fiap.odin.controller;

import com.fiap.odin.dto.SateliteDTO;
import com.fiap.odin.model.Satelite;
import com.fiap.odin.service.SateliteService;
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
@RequestMapping("/api/satelites")
@Tag(name = "Satélites", description = "Gerenciamento da frota orbital")
@CrossOrigin(origins = "*")
public class SateliteController {

    @Autowired
    private SateliteService service;

    @GetMapping
    @Operation(summary = "Listar todos os satélites com paginação")
    public ResponseEntity<Page<Satelite>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar satélite por ID")
    public ResponseEntity<Satelite> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo satélite")
    public ResponseEntity<Satelite> save(@Valid @RequestBody SateliteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar satélite existente")
    public ResponseEntity<Satelite> update(@PathVariable Long id, @Valid @RequestBody SateliteDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover satélite")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
