package br.controller;

import br.dao.UsuarioDao;
import br.model.Usuario;
import com.google.gson.Gson;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@PermitAll
@Path("/users")
public class UsuarioController {
    private List<Usuario> usuarios;
    {
        UsuarioDao usuarioDao = new UsuarioDao();

        try {
            usuarioDao = (UsuarioDao) usuarioDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @GET
    @Produces("application/json")
    public Response usuarios(){
        return Response.ok(new Gson().toJson(usuarios)).build();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response show(@PathParam("id") Integer id) {
        UsuarioDao usuarioDao = new UsuarioDao();
        return Response.ok(new Gson().toJson(usuarioDao.find(id))).build();
    }
    @POST
    @Consumes
    @Produces
    public  Response save(Usuario usuario){
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuarioCriado = usuarioDao.create(usuario);
        return  Response.ok(new Gson().toJson(usuarioCriado)).build();
    }
    @PUT
    @Path("/{id}")
    @Produces("application/json")
    public Response update(@PathParam("id") Integer id, Usuario usuario){
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario_atualizado = usuarioDao.update(usuario);
        return  Response.ok(new Gson().toJson(usuario_atualizado)).build();
    }
//    @DELETE
//    @Path("/{id}")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response update(@PathParam("id") Integer id){
//        UsuarioDao usuarioDao = new UsuarioDao();
//        Integer usuario_deletado = usuarioDao.delete(id);
//        return Response.ok(new Gson().toJson(usuario_deletado)).build();
//    }
}
