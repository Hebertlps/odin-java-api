package com.fiap.odin.repository;

import com.fiap.odin.model.Detrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetritoRepository extends JpaRepository<Detrito, Long> {
}
