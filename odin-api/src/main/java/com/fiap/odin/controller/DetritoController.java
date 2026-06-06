package com.fiap.odin.controller;

import com.fiap.odin.dto.DetritoDTO;
import com.fiap.odin.model.Detrito;
import com.fiap.odin.service.DetritoService;
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
@RequestMapping(value = "/api/detritos", name = "detritos")
@Tag(name = "Detritos", description = "Catálogo de lixo espacial rastreado")
@CrossOrigin(origins = "*")
public class DetritoController {

    @Autowired
    private DetritoService service;

    @GetMapping
    @Operation(summary = "Listar todos os detritos com paginação")
    public ResponseEntity<Page<Detrito>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar detrito por ID")
    public ResponseEntity<Detrito> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo detrito")
    public ResponseEntity<Detrito> save(@Valid @RequestBody DetritoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar detrito existente")
    public ResponseEntity<Detrito> update(@PathVariable Long id, @Valid @RequestBody DetritoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover detrito")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
