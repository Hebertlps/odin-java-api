package com.fiap.odin.service;

import com.fiap.odin.dto.SateliteDTO;
import com.fiap.odin.model.Satelite;
import com.fiap.odin.repository.SateliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SateliteService {

    @Autowired
    private SateliteRepository repository;

    public Page<Satelite> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Satelite findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Satélite não encontrado"));
    }

    @Transactional
    public Satelite save(SateliteDTO dto) {
        Satelite satelite = new Satelite();
        updateEntityFromDto(satelite, dto);
        return repository.save(satelite);
    }

    @Transactional
    public Satelite update(Long id, SateliteDTO dto) {
        Satelite satelite = findById(id);
        updateEntityFromDto(satelite, dto);
        return repository.save(satelite);
    }

    @Transactional
    public void delete(Long id) {
        Satelite satelite = findById(id);
        repository.delete(satelite);
    }

    private void updateEntityFromDto(Satelite satelite, SateliteDTO dto) {
        satelite.setNome(dto.nome());
        satelite.setCombustivelAtual(dto.combustivelAtual());
        satelite.setStatusOperacional(dto.statusOperacional());
        satelite.setCoordenada(dto.coordenada());
        satelite.setDataLancamento(dto.dataLancamento());
    }
}
