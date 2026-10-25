package com.database.Repository;

import com.database.Entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EscolaRepository extends JpaRepository<Escola, Long> {

    List<Escola> findByProvaCompletaFalse();
}
