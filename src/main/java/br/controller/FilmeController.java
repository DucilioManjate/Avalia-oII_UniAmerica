package br.controller;

import br.dao.GeneroDao;
import br.model.Genero;
import com.google.gson.Gson;
import com.sun.mail.iap.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.SQLException;
import java.util.List;

@Path("/filmes")
public class FilmeController {
    private List<Genero> filmes;
    {
        GeneroDao filmeDao = new GeneroDao();
        try {
            filmes = filmeDao.findAll();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    @GET
//    @Produces("application/json")
//    public Response filmes(){
//        return Response.ok(new Gson().toJson(filmes)).build();
//    }
//
//    @GET
//    @Path("/{id}")
//    @Produces("application/json")
//    public Response show(@PathParam("id") Integer id) {
//        GeneroDao filmeDao = new GeneroDao();
//        return Response.ok(new Gson().toJson(filmeDao.find(id))).build();
//    }

}
