package com.api.fleet.repository;

import com.api.fleet.entity.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexandre.entringer
 */
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}
