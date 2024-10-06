package com.api.fleet.utility;

import com.api.fleet.entity.Agendamentos;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author alexandre.entringer
 */
public class AgendamentosSpecification {

    public static Specification<Agendamentos> filtros(Long veiculoId, Long usuarioId, Long rotaId, Date dataInicio, Date dataFim) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Adiciona o filtro de veículo se veiculoId não for nulo
            if (veiculoId != null) {
                predicates.add(cb.equal(root.get("veiculo").get("id"), veiculoId));
            }

            // Adiciona o filtro de usuário se usuarioId não for nulo
            if (usuarioId != null) {
                predicates.add(cb.equal(root.get("usuario").get("id"), usuarioId));
            }

            // Adiciona o filtro de rota se rotaId não for nulo
            if (rotaId != null) {
                predicates.add(cb.equal(root.get("rota").get("id"), rotaId));
            }

            if (dataInicio != null && dataFim != null) {
                // Verifica se a data do agendamento está entre dataInicio e dataFim

                Calendar endCal = Calendar.getInstance();
                endCal.setTime(dataFim);
                endCal.set(Calendar.HOUR_OF_DAY, 23);
                endCal.set(Calendar.MINUTE, 59);
                endCal.set(Calendar.SECOND, 59);
                endCal.set(Calendar.MILLISECOND, 999);
                Date endOfDay = endCal.getTime();

                predicates.add(cb.between(root.get("dataInicio"), dataInicio, endOfDay));
            }

            // Converte a lista de predicados em um array
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
