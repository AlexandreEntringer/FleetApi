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

    public String updateMotivos(Long id, Motivos motivosAtualizado) {
        // Busca o motivo existente no banco de dados
        Motivos motivos = motivosRepository.findById(id).orElse(null);

        if (motivos != null) {
            motivos.setDescricao(motivosAtualizado.getDescricao());

            // Salva as alterações
            motivosRepository.save(motivos);
            return "Registro atualizado com sucesso!";
        } else {
            return "Registro não encontrado!";
        }
    }

    public String deleteById(Long id) {
        Motivos motivos = motivosRepository.findById(id).orElse(null);
        if (motivos == null) {
            return "Registro não encontrado!";
        } else if (motivos.getDataInativacao() != null) {
            motivos.setDataInativacao(null);
            motivosRepository.save(motivos);
            return "Registro ativado com sucesso!";
        } else {
            motivos.setDataInativacao(new Date());
            motivosRepository.save(motivos);
            return "Registro inativado com sucesso!";
        }
    }
}
