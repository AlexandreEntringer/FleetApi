package com.api.fleet.service;

import com.api.fleet.entity.Veiculos;
import com.api.fleet.repository.VeiculosRepository;
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
    
    public String updateVeiculos(Long id, Veiculos veiculosAtualizado) {
        // Busca o módulo existente no banco de dados
        Veiculos veiculos = veiculosRepository.findById(id).orElse(null);

        if (veiculos != null) {
            veiculos.setPlaca(veiculosAtualizado.getPlaca());
            veiculos.setModelo(veiculosAtualizado.getModelo());
            veiculos.setChassi(veiculosAtualizado.getChassi());

            // Salva as alterações
            veiculosRepository.save(veiculos);
            return "Registro atualizado com sucesso!";
        } else {
            return "Registro não encontrado!";
        }
    }

    public String deleteById(Long id) {
        Veiculos veiculos = veiculosRepository.findById(id).orElse(null);
            if(veiculos == null){
                return "Registro não encontrado!";
            }else if(veiculos.getDataInativacao() != null){
                veiculos.setDataInativacao(null);
                veiculosRepository.save(veiculos);
                return "Registro ativado com sucesso!";
            }else{
                veiculos.setDataInativacao(new Date());
                veiculosRepository.save(veiculos);
                return "Registro inativado com sucesso!";
            }
    }
}
