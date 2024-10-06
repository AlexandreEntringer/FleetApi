package com.api.fleet.service;

import com.api.fleet.entity.Usuarios;
import com.api.fleet.repository.UsuariosRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexandre.entringer
 */
@Service
public class UsuariosService {
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> findById(Long id) {
        return usuariosRepository.findById(id);
    }

    public Usuarios save(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    public String updateUsuarios(Long id, Usuarios usuariosAtualizado) {
        // Busca o usuário existente no banco de dados
        Usuarios usuarios = usuariosRepository.findById(id).orElse(null);

        if (usuarios != null) {
            usuarios.setEmail(usuariosAtualizado.getEmail());
            usuarios.setNome(usuariosAtualizado.getNome());
            usuarios.setRegistroCnh(usuariosAtualizado.getRegistroCnh());
            usuarios.setTelefone(usuariosAtualizado.getTelefone());
            
            // Salva as alterações
            usuariosRepository.save(usuarios);
            return "Registro atualizado com sucesso!";
        } else {
            return "Registro não encontrado!";
        }
    }

    public String deleteById(Long id) {
        Usuarios usuarios = usuariosRepository.findById(id).orElse(null);
        if (usuarios == null) {
            return "Registro não encontrado!";
        } else if (usuarios.getDataInativacao() != null) {
            usuarios.setDataInativacao(null);
            usuariosRepository.save(usuarios);
            return "Registro ativado com sucesso!";
        } else {
            usuarios.setDataInativacao(new Date());
            usuariosRepository.save(usuarios);
            return "Registro inativado com sucesso!";
        }
    }
    
    public Optional<Usuarios> buscaUsuarioPorCredencial(String username, String password){
        if (username == null || password == null) {
            throw new IllegalArgumentException("Os campos Usuário e Senha são obrigatórios!");
        }
        
        return usuariosRepository.findByFiltros(username, password);
    }
    
}
