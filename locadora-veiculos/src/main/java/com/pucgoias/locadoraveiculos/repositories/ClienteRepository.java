package com.pucgoias.locadoraveiculos.repositories;

import com.pucgoias.locadoraveiculos.domain.Aluguel;
import com.pucgoias.locadoraveiculos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
