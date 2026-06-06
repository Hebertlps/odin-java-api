package com.fiap.odin.service;

import com.fiap.odin.dto.DetritoDTO;
import com.fiap.odin.model.Detrito;
import com.fiap.odin.repository.DetritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetritoService {

    @Autowired
    private DetritoRepository repository;

    public Page<Detrito> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Detrito findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detrito não encontrado"));
    }

    @Transactional
    public Detrito save(DetritoDTO dto) {
        Detrito detrito = new Detrito();
        updateEntityFromDto(detrito, dto);
        return repository.save(detrito);
    }

    @Transactional
    public Detrito update(Long id, DetritoDTO dto) {
        Detrito detrito = findById(id);
        updateEntityFromDto(detrito, dto);
        return repository.save(detrito);
    }

    @Transactional
    public void delete(Long id) {
        Detrito detrito = findById(id);
        repository.delete(detrito);
    }

    private void updateEntityFromDto(Detrito detrito, DetritoDTO dto) {
        detrito.setNome(dto.nome());
        detrito.setTipo(dto.tipo());
        detrito.setCoordenada(dto.coordenada());
        detrito.setTamanhoEstimado(dto.tamanhoEstimado());
        detrito.setDataCatalogacao(dto.dataCatalogacao());
    }
}
