package com.stefanini.usuario.resource;

import com.stefanini.usuario.dto.PersistirUsuarioDTO;
import com.stefanini.usuario.dto.UsuarioTodosDadosDTO;
import com.stefanini.usuario.model.UsuarioModel;
import com.stefanini.usuario.service.UsuarioService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(usuarioService.findById(id)).build();
    }

    @GET
    public Response listAll(){
        return Response.ok(usuarioService.listAll()).build();
    }

    @GET
    @Path("/aniversariantes/{mes}")
    public Response aniversariantesPorMes(@PathParam("mes") Integer mes){
        return Response.ok(usuarioService.listarAniversariantesPorMes(mes)).build();
    }

    @GET
    @Path("/listarInicial/{inicial}")
    public Response listarPorInicial(@PathParam("inicial") String inicial){
        return Response.ok(usuarioService.listarPorInicial(inicial)).build();
    }

    @POST
    public Response save(@Valid PersistirUsuarioDTO persistirUsuarioDTO){
        UsuarioModel usuarioModel = usuarioService.save(persistirUsuarioDTO);
        if(Objects.nonNull(usuarioModel)) return Response.ok(persistirUsuarioDTO).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao processar requisição").build();
    }

}
