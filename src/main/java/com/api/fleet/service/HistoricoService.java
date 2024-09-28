package com.api.fleet.service;

import com.api.fleet.entity.Historico;
import com.api.fleet.repository.HistoricoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexandre.entringer
 */
@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public List<Historico> findAll() {
        return historicoRepository.findAll();
    }

    public Optional<Historico> findById(Long id) {
        return historicoRepository.findById(id);
    }

    public Historico save(Historico historico) {
        return historicoRepository.save(historico);
    }

    public String updateHistorico(Long id, Historico historicoAtualizado) {
        // Busca o historico existente no banco de dados
        Historico historico = historicoRepository.findById(id).orElse(null);

        if (historico != null) {
            historicoRepository.save(historicoAtualizado);
            return "Registro atualizado com sucesso!";
        } else {
            return "Registro não encontrado!";
        }
    }

    public String deleteById(Long id) {
        Historico historico = historicoRepository.findById(id).orElse(null);
        if (historico == null) {
            return "Registro não encontrado!";
        } else {
            historicoRepository.delete(historico);
            return "Registro inativado com sucesso!";
        }
    }

}
