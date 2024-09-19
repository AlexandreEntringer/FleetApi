package com.api.fleet.service;

import com.api.fleet.entity.Veiculos;
import com.api.fleet.repository.VeiculosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexandre.entringer
 */
@Service
public class VeiculosService {
    @Autowired
    private VeiculosRepository veiculosRepository;

    public List<Veiculos> findAll() {
        return veiculosRepository.findAll();
    }

    public Optional<Veiculos> findById(Long id) {
        return veiculosRepository.findById(id);
    }

    public Veiculos save(Veiculos veiculos) {
        return veiculosRepository.save(veiculos);
    }

    public void deleteById(Long id) {
        veiculosRepository.deleteById(id);
    }
}
