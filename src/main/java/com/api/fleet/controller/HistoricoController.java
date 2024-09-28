package com.api.fleet.controller;

import com.api.fleet.entity.Historico;
import com.api.fleet.service.HistoricoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<Historico> getAllHistorico() {
        return historicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historico> getHistoricoById(@PathVariable Long id) {
        Optional<Historico> historico = historicoService.findById(id);
        return historico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Historico createHistorico(@RequestBody Historico historico) {
        return historicoService.save(historico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateHistorico(@PathVariable Long id, @RequestBody Historico historico) {
        String resposta = historicoService.updateHistorico(id, historico);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistorico(@PathVariable Long id) {
        String resposta = historicoService.deleteById(id);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }
}
