package com.fiap.odin.service;

import com.fiap.odin.dto.AlertaDTO;
import com.fiap.odin.model.Alerta;
import com.fiap.odin.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository repository;

    @Autowired
    private SateliteService sateliteService;

    @Autowired
    private DetritoService detritoService;

    public Page<Alerta> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Alerta findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));
    }

    @Transactional
    public Alerta save(AlertaDTO dto) {
        Alerta alerta = new Alerta();
        updateEntityFromDto(alerta, dto);
        return repository.save(alerta);
    }

    @Transactional
    public Alerta update(Long id, AlertaDTO dto) {
        Alerta alerta = findById(id);
        updateEntityFromDto(alerta, dto);
        return repository.save(alerta);
    }

    @Transactional
    public void delete(Long id) {
        Alerta alerta = findById(id);
        repository.delete(alerta);
    }

    private void updateEntityFromDto(Alerta alerta, AlertaDTO dto) {
        alerta.setSatelite(sateliteService.findById(dto.sateliteId()));
        alerta.setDetrito(detritoService.findById(dto.detritoId()));
        alerta.setSeveridade(dto.severidade());
        alerta.setDescricao(dto.descricao());
        alerta.setStatus(dto.status());
    }
}
