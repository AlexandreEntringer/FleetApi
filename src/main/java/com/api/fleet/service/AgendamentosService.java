package com.api.fleet.service;

import com.api.fleet.entity.Agendamentos;
import com.api.fleet.repository.AgendamentosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexandre.entringer
 */
@Service
public class AgendamentosService {
    
    @Autowired
    private AgendamentosRepository agendamentosRepository;
    
    public List<Agendamentos> findAll() {
        return agendamentosRepository.findAll();
    }

    public Optional<Agendamentos> findById(Long id) {
        return agendamentosRepository.findById(id);
    }

    public Agendamentos save(Agendamentos agendamentos) {
        return agendamentosRepository.save(agendamentos);
    }

    public void deleteById(Long id) {
        agendamentosRepository.deleteById(id);
    }  
}
