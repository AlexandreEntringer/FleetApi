/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.fleet.service;

import com.api.fleet.entity.Modulos;
import com.api.fleet.repository.ModulosRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fabricio Aleixo
 */
@Service
public class ModulosService {
    
    @Autowired
    private ModulosRepository modulosRepository;

    public List<Modulos> findAll() {
        return modulosRepository.findAll();
    }

    public Optional<Modulos> findById(Long id) {
        return modulosRepository.findById(id);
    }

    public Modulos save(Modulos modulos) {
        return modulosRepository.save(modulos);
    }

    public void deleteById(Long id) {
        Modulos modulos = modulosRepository.findById(id).orElse(null);
        modulos.setDataInativacao(new Date());
        modulosRepository.save(modulos);
    }
}
