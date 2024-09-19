package com.api.fleet.controller;

import com.api.fleet.entity.Motivos;
import com.api.fleet.entity.Veiculos;
import com.api.fleet.service.MotivosService;
import com.api.fleet.service.VeiculosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Veiculos createMotivos(@RequestBody Veiculos veiculos) {
        return veiculosService.save(veiculos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotivos(@PathVariable Long id) {
        veiculosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }
}
