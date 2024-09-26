package com.api.fleet.repository;

import com.api.fleet.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexandre.entringer
 */
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{ 
}
