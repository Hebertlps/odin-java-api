package com.fiap.odin.service;

import com.fiap.odin.dto.OperadorDTO;
import com.fiap.odin.model.Operador;
import com.fiap.odin.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperadorService {

    @Autowired
    private OperadorRepository repository;

    public Page<Operador> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Operador findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operador não encontrado"));
    }

    @Transactional
    public Operador save(OperadorDTO dto) {
        Operador operador = new Operador();
        updateEntityFromDto(operador, dto);
        return repository.save(operador);
    }

    @Transactional
    public Operador update(Long id, OperadorDTO dto) {
        Operador operador = findById(id);
        updateEntityFromDto(operador, dto);
        return repository.save(operador);
    }

    @Transactional
    public void delete(Long id) {
        Operador operador = findById(id);
        repository.delete(operador);
    }

    private void updateEntityFromDto(Operador operador, OperadorDTO dto) {
        operador.setNome(dto.nome());
        operador.setEmail(dto.email());
        operador.setSenhaHash(dto.senhaHash());
        operador.setTipoAcesso(dto.tipoAcesso());
        operador.setDataContratacao(dto.dataContratacao());
    }
}
