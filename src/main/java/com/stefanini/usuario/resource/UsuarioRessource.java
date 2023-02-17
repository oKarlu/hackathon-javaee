package com.stefanini.usuario.resource;

import com.stefanini.usuario.service.UsuarioService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRessource {

    @Inject
    private UsuarioService usuarioService;

}
