package br.teste;

import br.dao.GeneroDao;
import br.model.Genero;

import java.sql.SQLException;
import java.util.List;

public class GeneroTest {
    public static void main(String[] args) throws SQLException {
        GeneroDao generoDao = new GeneroDao();

        List<Genero> generos = generoDao.findAll();

        for (Genero genero : generos){
            System.out.println(genero);
        }
    }
}
