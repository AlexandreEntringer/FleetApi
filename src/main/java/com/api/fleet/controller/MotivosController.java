package com.api.fleet.controller;
import com.api.fleet.entity.Motivos;
import com.api.fleet.repository.MotivosRepository;
import com.api.fleet.service.MotivosService;
import java.util.Date;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotivos(@PathVariable Long id) {
        motivosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Motivos> updateMotivo(@PathVariable Long id, @RequestBody Motivos motivos) {
        motivosService.save(motivos);
        return ResponseEntity.ok(motivos);
    }
}
