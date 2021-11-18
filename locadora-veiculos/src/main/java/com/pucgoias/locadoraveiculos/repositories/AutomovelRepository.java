package com.pucgoias.locadoraveiculos.repositories;

import com.pucgoias.locadoraveiculos.domain.Aluguel;
import com.pucgoias.locadoraveiculos.domain.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
}
