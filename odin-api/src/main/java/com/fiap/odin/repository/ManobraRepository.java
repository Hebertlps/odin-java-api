package com.fiap.odin.repository;

import com.fiap.odin.model.Manobra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManobraRepository extends JpaRepository<Manobra, Long> {
}
