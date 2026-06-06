package com.fiap.odin.controller;

import com.fiap.odin.dto.OperadorDTO;
import com.fiap.odin.model.Operador;
import com.fiap.odin.service.OperadorService;
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
@RequestMapping(value = "/api/operadores", name = "operadores")
@Tag(name = "Operadores", description = "Gerenciamento de engenheiros autorizados")
@CrossOrigin(origins = "*")
public class OperadorController {

    @Autowired
    private OperadorService service;

    @GetMapping
    @Operation(summary = "Listar todos os operadores com paginação")
    public ResponseEntity<Page<Operador>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar operador por ID")
    public ResponseEntity<Operador> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo operador")
    public ResponseEntity<Operador> save(@Valid @RequestBody OperadorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar operador existente")
    public ResponseEntity<Operador> update(@PathVariable Long id, @Valid @RequestBody OperadorDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover operador")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
