package com.stefanini.usuario.dao;

import com.stefanini.dao.GenericDAO;
import com.stefanini.usuario.dto.CorpoRespostaAniversariantesDTO;
import com.stefanini.usuario.dto.UsuarioTodosDadosDTO;
import com.stefanini.usuario.model.UsuarioModel;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
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

    public List<String> listarProvedoresDeEmail(){
        String hql = "SELECT DISTINCT SUBSTRING(email_usuario, LOCATE('@', email_usuario) + 1) AS provedor_email FROM UsuarioModel";
        Query query = createQuery2(hql);
        List<String> result = query.getResultList();
        return result;
    }
}
