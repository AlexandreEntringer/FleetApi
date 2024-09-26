package com.api.fleet.controller;

import com.api.fleet.entity.Rotas;
import com.api.fleet.service.RotasService;
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
@RequestMapping("/rotas")
public class RotasController {

    @Autowired
    private RotasService rotasService;

    @GetMapping
    public List<Rotas> getAllRotas() {
        return rotasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rotas> getRotasById(@PathVariable Long id) {
        Optional<Rotas> rotas = rotasService.findById(id);
        return rotas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rotas createRotas(@RequestBody Rotas rotas) {
        rotas.setDataRegistro(new Date());
        return rotasService.save(rotas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRotas(@PathVariable Long id, @RequestBody Rotas rotas) {
        String resposta = rotasService.updateRotas(id, rotas);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRotas(@PathVariable Long id) {
        String resposta = rotasService.deleteById(id);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }
}
