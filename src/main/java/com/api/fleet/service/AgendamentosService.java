package com.api.fleet.service;

import com.api.fleet.entity.Agendamentos;
import com.api.fleet.repository.AgendamentosRepository;
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

    public String updateModulos(Long id, Agendamentos agendamentosAtualizado) {
        // Busca o módulo existente no banco de dados
        Agendamentos agendamentos = agendamentosRepository.findById(id).orElse(null);

        if (agendamentos != null) {
            agendamentos.setMotivo(agendamentosAtualizado.getMotivo());
            agendamentos.setDataInicio(agendamentosAtualizado.getDataInicio());
            agendamentos.setDataFim(agendamentosAtualizado.getDataFim());
            agendamentos.setRota(agendamentosAtualizado.getRota());
            agendamentos.setStatus(agendamentosAtualizado.getStatus());
            agendamentos.setUsuario(agendamentosAtualizado.getUsuario());
            agendamentos.setVeiculo(agendamentosAtualizado.getVeiculo());

            // Salva as alterações
            agendamentosRepository.save(agendamentos);
            return "Registro atualizado com sucesso!";
        } else {
            return "Registro não encontrado!";
        }
    }

    public String deleteById(Long id) {
        Agendamentos agendamentos = agendamentosRepository.findById(id).orElse(null);
        if (agendamentos == null) {
            return "Registro não encontrado!";
        } else if (agendamentos.getDataInativacao() != null) {
            agendamentos.setDataInativacao(null);
            agendamentosRepository.save(agendamentos);
            return "Registro ativado com sucesso!";
        } else {
            agendamentos.setDataInativacao(new Date());
           agendamentosRepository.save(agendamentos);
            return "Registro inativado com sucesso!";
        }
    }  
}
