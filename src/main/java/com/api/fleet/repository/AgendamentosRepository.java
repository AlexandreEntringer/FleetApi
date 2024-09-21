package com.api.fleet.repository;

import com.api.fleet.entity.Agendamentos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexandre.entringer
 */
public interface AgendamentosRepository extends JpaRepository<Agendamentos, Long>{ 
}
