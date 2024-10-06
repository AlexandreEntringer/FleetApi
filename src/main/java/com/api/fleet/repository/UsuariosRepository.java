package com.api.fleet.repository;

import com.api.fleet.entity.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author alexandre.entringer
 */
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{ 
    @Query("SELECT u FROM Usuarios u WHERE " +
            "u.username = :username AND u.password = :password")
    Optional<Usuarios> findByFiltros(
            @Param("username") String username,
            @Param("password") String password);
}
