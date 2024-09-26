package com.api.fleet.controller;

import com.api.fleet.entity.Veiculos;
import com.api.fleet.service.VeiculosService;
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
 * @author Fabricio Aleixo
 */
@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculosService veiculosService;

    @GetMapping
    public List<Veiculos> getAllVeiculos() {
        return veiculosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculos> getVeiculosById(@PathVariable Long id) {
        Optional<Veiculos> veiculos = veiculosService.findById(id);
        return veiculos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Veiculos createVeiculos(@RequestBody Veiculos veiculos) {
        veiculos.setDataRegistro(new Date());
        return veiculosService.save(veiculos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRotas(@PathVariable Long id, @RequestBody Veiculos veiculos) {
        String resposta = veiculosService.updateVeiculos(id, veiculos);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRotas(@PathVariable Long id) {
        String resposta = veiculosService.deleteById(id);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }
}
