/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.fleet.controller;

import com.api.fleet.entity.Modulos;
import com.api.fleet.service.ModulosService;
import java.util.Date;
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
@RequestMapping("/modulos")
public class ModulosController {
 
    @Autowired
    private ModulosService modulosService;

    @GetMapping
    public List<Modulos> getAllModulos() {
        return modulosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modulos> getModulosById(@PathVariable Long id) {
        Optional<Modulos> modulos = modulosService.findById(id);
        return modulos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Modulos> createModulos(@RequestBody String descricao) {
        Modulos ModuloNovo = new Modulos(descricao);
        ModuloNovo.setDataRegistro(new Date());
        modulosService.save(ModuloNovo);
        return ResponseEntity.ok(ModuloNovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModulos(@PathVariable Long id) {
        modulosService.deleteById(id);
        return ResponseEntity.ok("Registro inativado com Sucesso");
    }  
}
