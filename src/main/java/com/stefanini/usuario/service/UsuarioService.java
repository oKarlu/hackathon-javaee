package com.stefanini.usuario.service;

import com.stefanini.usuario.dao.UsuarioDAO;
import com.stefanini.usuario.dto.UsuarioTodosDadosDTO;
import com.stefanini.usuario.model.UsuarioModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioDAO usuarioDAO;

    public UsuarioService() {
    }

    public UsuarioTodosDadosDTO findById(Long id){
        UsuarioModel usuarioModel = usuarioDAO.findById(id);
        return new UsuarioTodosDadosDTO(usuarioModel);
    }

    @Transactional
    public UsuarioModel save(UsuarioTodosDadosDTO usuarioTodosDadosDTO){
        UsuarioModel usuarioModel = new UsuarioModel(usuarioTodosDadosDTO);
        usuarioDAO.save(usuarioModel);
        return usuarioModel;
    }

    public List<UsuarioTodosDadosDTO> listAll(){
        List<UsuarioModel> listUsuario = usuarioDAO.listAll();
        return listUsuario.stream().map(UsuarioTodosDadosDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public UsuarioTodosDadosDTO update(UsuarioTodosDadosDTO usuarioTodosDadosDTO){
        UsuarioModel usuarioModel = new UsuarioModel(usuarioTodosDadosDTO);
        usuarioDAO.update(usuarioModel);
        return new UsuarioTodosDadosDTO(usuarioModel);
    }

    @Transactional
    public void delete(Long id){
        UsuarioModel usuarioModel = usuarioDAO.findById(id);
        usuarioDAO.delete(usuarioModel.getIdUsuario());
    }

    public List<UsuarioTodosDadosDTO> listarAniversariantes(Integer mes){
        Query query = usuarioDAO.createNativeQuery("SELECT * FROM tb_usuario WHERE month(data_nascimento_usuario) = ?");
        query.setParameter(1, mes);
        List<UsuarioModel> result = query.getResultList();
        return result.stream().map(UsuarioTodosDadosDTO::new).collect(Collectors.toList());
    }
    
}
