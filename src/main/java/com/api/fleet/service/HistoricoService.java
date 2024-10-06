package com.api.fleet.service;

import com.api.fleet.entity.Agendamentos;
import com.api.fleet.repository.AgendamentosRepository;
import com.api.fleet.utility.AgendamentosSpecification;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexandre.entringer
 */
@Service
public class HistoricoService {

    @Autowired
    private AgendamentosRepository agendamentosRepository;

    public List<Agendamentos> buscarHistoricoComFiltros(Long veiculoId, Long usuarioId, Long rotaId, Date dataInicio, Date dataFim) {
        // Gera a Specification com base nos parâmetros fornecidos
        Specification<Agendamentos> specification = AgendamentosSpecification.filtros(veiculoId, usuarioId, rotaId, dataInicio, dataFim);
        
        // Chama o repositório para buscar os dados de acordo com a Specification
        return agendamentosRepository.findAll(specification);
    }
}
