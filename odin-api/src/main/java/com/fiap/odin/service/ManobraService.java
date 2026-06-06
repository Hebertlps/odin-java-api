package com.fiap.odin.service;

import com.fiap.odin.dto.ManobraDTO;
import com.fiap.odin.model.Manobra;
import com.fiap.odin.repository.ManobraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class ManobraService {

    @Autowired
    private ManobraRepository repository;

    @Autowired
    private SateliteService sateliteService;

    @Autowired
    private OperadorService operadorService;

    public Page<Manobra> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Manobra findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manobra nao encontrada com ID: " + id));
    }

    @Transactional
    public Manobra save(ManobraDTO dto) {
        Manobra manobra = new Manobra();
        updateEntityFromDto(manobra, dto);
        return repository.save(manobra);
    }

    @Transactional
    public Manobra update(Long id, ManobraDTO dto) {
        Manobra manobra = findById(id);
        updateEntityFromDto(manobra, dto);
        return repository.save(manobra);
    }

    @Transactional
    public void delete(Long id) {
        Manobra manobra = findById(id);
        repository.delete(manobra);
    }

    private void updateEntityFromDto(Manobra manobra, ManobraDTO dto) {
        manobra.setSatelite(sateliteService.findById(dto.sateliteId()));
        manobra.setOperador(operadorService.findById(dto.operadorId()));
        manobra.setDataManobra(dto.dataManobra() != null ? dto.dataManobra() : LocalDateTime.now());
        manobra.setTipoManobra(dto.tipoManobra());
        manobra.setCombustivelConsumido(dto.combustivelConsumido());
        manobra.setResultado(dto.resultado());
        manobra.setDescricao(dto.descricao());
    }
}
