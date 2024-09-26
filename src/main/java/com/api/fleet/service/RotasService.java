package com.api.fleet.service;

import com.api.fleet.entity.Rotas;
import com.api.fleet.repository.RotasRepository;
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

    public String updateRotas(Long id, Rotas rotasAtualizado) {
        // Busca o módulo existente no banco de dados
        Rotas rotas = rotasRepository.findById(id).orElse(null);

        if (rotas != null) {
            rotas.setDescricao(rotasAtualizado.getDescricao());
            rotas.setOrigem(rotasAtualizado.getOrigem());
            rotas.setDestino(rotasAtualizado.getDestino());

            // Salva as alterações
            rotasRepository.save(rotas);
            return "Registro atualizado com sucesso!";
        } else {
            return "Registro não encontrado!";
        }
    }

    public String deleteById(Long id) {
        Rotas rotas = rotasRepository.findById(id).orElse(null);
        if (rotas == null) {
            return "Registro não encontrado!";
        } else if (rotas.getDataInativacao() != null) {
            rotas.setDataInativacao(null);
            rotasRepository.save(rotas);
            return "Registro ativado com sucesso!";
        } else {
            rotas.setDataInativacao(new Date());
            rotasRepository.save(rotas);
            return "Registro inativado com sucesso!";
        }
    }
}
