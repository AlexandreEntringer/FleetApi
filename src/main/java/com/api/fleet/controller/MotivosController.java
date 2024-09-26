package com.api.fleet.controller;

import com.api.fleet.entity.Motivos;
import com.api.fleet.service.MotivosService;
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
@RequestMapping("/motivos")
public class MotivosController {

    @Autowired
    private MotivosService motivosService;

    @GetMapping
    public List<Motivos> getAllMotivos() {
        return motivosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motivos> getMotivosById(@PathVariable Long id) {
        Optional<Motivos> motivos = motivosService.findById(id);
        return motivos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Motivos createMotivos(@RequestBody Motivos motivos) {
        motivos.setDataRegistro(new Date());
        return motivosService.save(motivos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMotivos(@PathVariable Long id, @RequestBody Motivos motivos) {
        String resposta = motivosService.updateMotivos(id, motivos);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMotivos(@PathVariable Long id) {
        String resposta = motivosService.deleteById(id);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }
}
