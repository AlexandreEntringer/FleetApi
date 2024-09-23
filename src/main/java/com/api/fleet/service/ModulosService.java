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
    
     public String updateModulos(Long id, Modulos modulosAtualizado) {
        // Busca o módulo existente no banco de dados
        Modulos modulos = modulosRepository.findById(id).orElse(null);

        if (modulos != null) {
            // Atualiza os campos permitidos e valida existencia para alterar
            if(modulosAtualizado.getDataRegistro() != null){
                modulos.setDataRegistro(modulosAtualizado.getDataRegistro());
            }
            if(modulosAtualizado.getDataInativacao()!= null){
                modulos.setDataInativacao(modulosAtualizado.getDataInativacao());
            }
            modulos.setDescricao(modulosAtualizado.getDescricao());

            // Salva as alterações
            modulosRepository.save(modulos);
            return "Registro atualizado com sucesso!";
        } else {
            return "Registro não encontrado!";
        }
    }
    
    public String deleteById(Long id) {
        Modulos modulos = modulosRepository.findById(id).orElse(null);
        if(modulos == null){
            return "Registro não encontrado!";
        }else if(modulos.getDataInativacao() != null){
            modulos.setDataInativacao(null);
            modulosRepository.save(modulos);
            return "Registro ativado com sucesso!";
        }else{
            modulos.setDataInativacao(new Date());
            modulosRepository.save(modulos);
            return "Registro inativado com sucesso!";
        }
    }
    
}
