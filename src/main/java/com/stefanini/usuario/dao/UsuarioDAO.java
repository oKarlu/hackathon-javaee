package com.stefanini.usuario.dao;

import com.stefanini.dao.GenericDAO;
import com.stefanini.usuario.dto.CorpoRespostaAniversariantesDTO;
import com.stefanini.usuario.dto.UsuarioTodosDadosDTO;
import com.stefanini.usuario.model.UsuarioModel;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioDAO extends GenericDAO<UsuarioModel, Long> {

    public List<CorpoRespostaAniversariantesDTO> listarAniversariantesPorMes(Integer mes){
        String hql = "SELECT * FROM tb_usuario WHERE month(data_nascimento_usuario) = ?";
        Query query = createNativeQuery(hql);
        query.setParameter(1, mes);
        List<UsuarioModel> result = query.getResultList();
        return result.stream().map(CorpoRespostaAniversariantesDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioTodosDadosDTO> listarPorInicial(String letra){
        String hql = "SELECT * FROM tb_usuario WHERE nome_usuario LIKE ?";
        Query query = createNativeQuery(hql);
        query.setParameter(1, letra + "%");
        List<UsuarioModel> result = query.getResultList();
        return result.stream().map(UsuarioTodosDadosDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioTodosDadosDTO> listarProvedoresDeEmail(){
        Query query = createNativeQuery("SELECT * FROM tb_usuario WHERE email_usuario LIKE @%");
        HashSet<UsuarioModel> result = (HashSet<UsuarioModel>) query.getResultList();
        return result.stream().map(UsuarioTodosDadosDTO::new).collect(Collectors.toList());
    }
}
