package br.controller;

import br.dao.GeneroDao;
import br.dao.UsuarioDao;
import br.model.Genero;
import com.google.gson.Gson;
import com.sun.mail.iap.Response;

import javax.annotation.security.PermitAll;
import javax.websocket.server.PathParam;
import javax.ws.rs.*;
import java.sql.SQLException;
import java.util.List;

@PermitAll
@Path("/generos")
public class GeneroController {

    private List<Genero> generos;
    {
        GeneroDao generoDao = new GeneroDao();
        try {
            generos = generoDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//    @GET
//    @Produces("application/json")
//    public Response generos(){
//        return Response.ok(new Gson().toJson(generos)).build();
//    }
//@GET
//@Path("/{id}")
//@Produces("application/json")
//public Response show(@PathParam("id") Integer id) {
//    GeneroDao generoDao = new GeneroDao();
//    return Response.ok(new Gson().toJson(generoDao.find(id))).build();
//}
//@POST
//@Consumes("application/json")
//@Produces("application/json")
//public Response save(Genero genero){
//    GeneroDao generodao = new GeneroDao();
//   Genero genero_criado = generodao.create(genero);
//    return Response.ok(new Gson().toJson(genero_criado)).build();
//}

}
