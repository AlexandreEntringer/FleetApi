package com.api.fleet.controller;

import com.api.fleet.entity.Agendamentos;
import com.api.fleet.service.HistoricoService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexandre.entringer
 */
@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public ResponseEntity<List<Agendamentos>> buscarHistorico(
            @RequestParam(required = false) Long veiculoId,
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(required = false) Long rotaId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim) {

        // Chama o service que retorna o histórico (dados de Agendamentos)
        List<Agendamentos> historico = historicoService.buscarHistoricoComFiltros(veiculoId, usuarioId, rotaId, dataInicio, dataFim);

        return ResponseEntity.ok(historico);
    }
}
