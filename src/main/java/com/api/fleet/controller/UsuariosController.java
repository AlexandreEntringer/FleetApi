package com.api.fleet.controller;

import com.api.fleet.entity.Usuarios;
import com.api.fleet.service.UsuariosService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexandre.entringer
 */
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuariosService;
    
    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuariosService.findAll();
    }
    
    @GetMapping("/login")
    public ResponseEntity<Usuarios> buscaUsuario(
            @RequestParam(required = true) String username,
            @RequestParam(required = true) String password) {

        // Chama o service que retorna o histórico (dados de Agendamentos)
        Optional<Usuarios> usuario = usuariosService.buscaUsuarioPorCredencial(username, password);

        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuariosById(@PathVariable Long id) {
        Optional<Usuarios> usuarios = usuariosService.findById(id);
        return usuarios.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuarios createUsuarios(@RequestBody Usuarios usuarios) {
        usuarios.setDataRegistro(new Date());
        return usuariosService.save(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuarios(@PathVariable Long id, @RequestBody Usuarios usuarios) {
        String resposta = usuariosService.updateUsuarios(id, usuarios);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuarios(@PathVariable Long id) {
        String resposta = usuariosService.deleteById(id);
        if ("Registro não encontrado!".equals(resposta)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        } else {
            return ResponseEntity.ok(resposta);
        }
    }
}
