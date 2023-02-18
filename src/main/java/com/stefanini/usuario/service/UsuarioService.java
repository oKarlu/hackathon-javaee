package com.stefanini.usuario.service;

import com.stefanini.usuario.dao.UsuarioDAO;
import com.stefanini.usuario.dto.CorpoRespostaAniversariantesDTO;
import com.stefanini.usuario.dto.UsuarioTodosDadosDTO;
import com.stefanini.usuario.model.UsuarioModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
        usuarioModel.setDataCriancaoUsuario(LocalDateTime.now());
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
        usuarioModel.setDataAtualizacaoUsuario(LocalDateTime.now());
        usuarioDAO.update(usuarioModel);
        return new UsuarioTodosDadosDTO(usuarioModel);
    }

    @Transactional
    public void delete(Long id){
        UsuarioModel usuarioModel = usuarioDAO.findById(id);
        usuarioDAO.delete(usuarioModel.getIdUsuario());
    }

    public List<CorpoRespostaAniversariantesDTO> listarAniversariantesPorMes(Integer mes){
        return usuarioDAO.listarAniversariantesPorMes(mes);
    }

    public List<UsuarioTodosDadosDTO> listarPorInicial(String letra){
        return usuarioDAO.listarPorInicial(letra);
    }

    public List<UsuarioTodosDadosDTO> listarProvedoresDeEmail(){
        return usuarioDAO.listarProvedoresDeEmail();
    }

}
