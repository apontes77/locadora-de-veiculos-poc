package com.pucgoias.locadoraveiculos.repositories;

import com.pucgoias.locadoraveiculos.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
