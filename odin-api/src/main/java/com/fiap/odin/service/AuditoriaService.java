package com.fiap.odin.service;

import com.fiap.odin.dto.AuditoriaDTO;
import com.fiap.odin.model.Auditoria;
import com.fiap.odin.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository repository;

    @Autowired
    private OperadorService operadorService;

    public Page<Auditoria> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Auditoria findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auditoria não encontrada"));
    }

    @Transactional
    public Auditoria save(AuditoriaDTO dto) {
        Auditoria auditoria = new Auditoria();
        updateEntityFromDto(auditoria, dto);
        return repository.save(auditoria);
    }

    @Transactional
    public Auditoria update(Long id, AuditoriaDTO dto) {
        Auditoria auditoria = findById(id);
        updateEntityFromDto(auditoria, dto);
        return repository.save(auditoria);
    }

    @Transactional
    public void delete(Long id) {
        Auditoria auditoria = findById(id);
        repository.delete(auditoria);
    }

    private void updateEntityFromDto(Auditoria auditoria, AuditoriaDTO dto) {
        auditoria.setOperador(operadorService.findById(dto.operadorId()));
        auditoria.setTipoOperacao(dto.tipoAcao());
        auditoria.setDetalhes(dto.detalhes());
        auditoria.setNomeUsuario(dto.nomeUsuario() != null ? dto.nomeUsuario() : "SISTEMA");
    }
}
