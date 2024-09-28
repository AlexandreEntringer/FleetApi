package com.api.fleet.service;

import com.api.fleet.entity.PerfilAcesso;
import com.api.fleet.repository.PerfilAcessoRepository;
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
public class PerfilAcessoService {

    @Autowired
    private PerfilAcessoRepository perfilAcessoRepository;

    public List<PerfilAcesso> findAll() {
        return perfilAcessoRepository.findAll();
    }

    public Optional<PerfilAcesso> findById(Long id) {
        return perfilAcessoRepository.findById(id);
    }

    public PerfilAcesso save(PerfilAcesso perfilAcesso) {
        return perfilAcessoRepository.save(perfilAcesso);
    }

    public String updatePerfilAcesso(Long id, PerfilAcesso perfilAcessoAtualizado) {
        // Busca o perfil de acesso existente no banco de dados
        PerfilAcesso perfilAcesso = perfilAcessoRepository.findById(id).orElse(null);

        if (perfilAcesso != null) {
            perfilAcesso.setModulo(perfilAcessoAtualizado.getModulo());
            perfilAcesso.setUsuario(perfilAcessoAtualizado.getUsuario());
            
            // Salva as alterações
            perfilAcessoRepository.save(perfilAcesso);
            return "Registro atualizado com sucesso!";
        } else {
            return "Registro não encontrado!";
        }
    }

    public String deleteById(Long id) {
        PerfilAcesso perfilAcesso = perfilAcessoRepository.findById(id).orElse(null);
        if (perfilAcesso == null) {
            return "Registro não encontrado!";
        } else if (perfilAcesso.getDataInativacao() != null) {
            perfilAcesso.setDataInativacao(null);
            perfilAcessoRepository.save(perfilAcesso);
            return "Registro ativado com sucesso!";
        } else {
            perfilAcesso.setDataInativacao(new Date());
            perfilAcessoRepository.save(perfilAcesso);
            return "Registro inativado com sucesso!";
        }
    }
}
