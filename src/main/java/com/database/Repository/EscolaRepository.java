package com.database.Repository;

import com.database.Entity.Escola;
import com.database.dto.EscolaResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EscolaRepository extends JpaRepository<Escola, Long> {

    List<EscolaResponse> findByProvaCompletaFalse();
}
