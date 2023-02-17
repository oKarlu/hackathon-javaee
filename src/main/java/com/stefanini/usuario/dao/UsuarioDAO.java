package com.stefanini.usuario.dao;

import com.stefanini.dao.GenericDAO;
import com.stefanini.usuario.model.UsuarioModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDAO extends GenericDAO<UsuarioModel, Long> {

}
