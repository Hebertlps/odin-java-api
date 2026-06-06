package com.fiap.odin.repository;

import com.fiap.odin.model.Satelite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SateliteRepository extends JpaRepository<Satelite, Long> {
}
