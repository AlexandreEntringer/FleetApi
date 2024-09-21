package com.api.fleet.service;

import com.api.fleet.entity.Motivos;
import com.api.fleet.repository.MotivosRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexandre.entringer
 */
@Service
public class MotivosService {

    @Autowired
    private MotivosRepository motivosRepository;

    public List<Motivos> findAll() {
        return motivosRepository.findAll();
    }

    public Optional<Motivos> findById(Long id) {
        return motivosRepository.findById(id);
    }

    public Motivos save(Motivos motivos) {
        return motivosRepository.save(motivos);
    }

    public void deleteById(Long id) {
        Motivos motivos = motivosRepository.findById(id).orElse(null);
        motivos.setDataInativacao(new Date());
        motivosRepository.save(motivos);
    }
}