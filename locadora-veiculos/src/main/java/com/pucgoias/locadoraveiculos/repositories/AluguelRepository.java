package com.pucgoias.locadoraveiculos.repositories;

import com.pucgoias.locadoraveiculos.domain.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
