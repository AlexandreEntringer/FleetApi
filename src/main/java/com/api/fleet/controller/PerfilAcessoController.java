package com.api.fleet.controller;

import com.api.fleet.entity.PerfilAcesso;
import com.api.fleet.service.PerfilAcessoService;
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
@RequestMapping("/perfilAcesso")
public class PerfilAcessoController {

    @Autowired
    private PerfilAcessoService perfilAcessoService;

    @GetMapping
    public List<PerfilAcesso> getAllPerfilAcesso() {
        return perfilAcessoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilAcesso> getPerfilAcessoById(@PathVariable Long id) {
        Optional<PerfilAcesso> perfilAcesso = perfilAcessoService.findById(id);
        return perfilAcesso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PerfilAcesso createPerfilAcesso(@RequestBody PerfilAcesso perfilAcesso) {
        perfilAcesso.setDataRegistro(new Date());
        return perfilAcessoService.save(perfilAcesso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerfilAcesso(@PathVariable Long id, @RequestBody PerfilAcesso perfilAcesso) {
        String resposta = perfilAcessoService.updatePerfilAcesso(id, perfilAcesso);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerfilAcesso(@PathVariable Long id) {
        String resposta = perfilAcessoService.deleteById(id);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }
}
