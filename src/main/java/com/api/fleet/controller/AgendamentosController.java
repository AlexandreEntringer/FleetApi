package com.api.fleet.controller;

import com.api.fleet.entity.Agendamentos;
import com.api.fleet.entity.Motivos;
import com.api.fleet.service.AgendamentosService;
import com.api.fleet.service.MotivosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
        return agendamentosService.save(agendamentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamentos(@PathVariable Long id) {
        agendamentosService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Agendamentos> updateAgendamentos(@PathVariable Long id, @RequestBody Agendamentos agendamentos) {
        agendamentosService.save(agendamentos);
        return ResponseEntity.ok(agendamentos);
    }
}
