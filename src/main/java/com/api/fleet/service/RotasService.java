package com.api.fleet.service;

import com.api.fleet.entity.Rotas;
import com.api.fleet.repository.RotasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexandre.entringer
 */
@Service
public class RotasService {
    @Autowired
    private RotasRepository rotasRepository;

    public List<Rotas> findAll() {
        return rotasRepository.findAll();
    }

    public Optional<Rotas> findById(Long id) {
        return rotasRepository.findById(id);
    }

    public Rotas save(Rotas rotas) {
        return rotasRepository.save(rotas);
    }

    public void deleteById(Long id) {
        rotasRepository.deleteById(id);
    }
}
