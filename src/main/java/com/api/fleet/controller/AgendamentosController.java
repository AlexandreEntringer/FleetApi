package com.api.fleet.controller;

import com.api.fleet.entity.Agendamentos;
import com.api.fleet.service.AgendamentosService;
import java.util.Date;
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
@RequestMapping("/agendamentos")
public class AgendamentosController {

    @Autowired
    private AgendamentosService agendamentosService;

    @GetMapping
    public List<Agendamentos> getAllAgendamentos() {
        return agendamentosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamentos> getAgendamentosById(@PathVariable Long id) {
        Optional<Agendamentos> agendamentos = agendamentosService.findById(id);
        return agendamentos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agendamentos createAgendamentos(@RequestBody Agendamentos agendamentos) {
        agendamentos.setDataRegistro(new Date());
        return agendamentosService.save(agendamentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAgendamentos(@PathVariable Long id, @RequestBody Agendamentos agendamentos) {
        String resposta = agendamentosService.updateAgendamentos(id, agendamentos);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgendamentos(@PathVariable Long id) {
        String resposta = agendamentosService.deleteById(id);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }
}
