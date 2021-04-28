package br.dao;

import br.factory.ConnectionFactory;
import br.model.Filme;
import br.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao {
  private Connection connection;
  public FilmeDao(){
      this.connection = ConnectionFactory.getConnection();
      GeneroDao generoDao = new GeneroDao();
      this.createTableMovie();
      this.createTableGenero();
  }

    private void createTableMovie() {
        String sql = "CREATE TABLE filme(\n" +
                "id INTEGER NOT NULL AUTO_INCREMENT,\n" +
                "nome VARCHAR(40) NOT NULL,\n" +
                "duracao INT NOT NULL,\n" +
                "PRIMARY KEY(id));";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println(" tabelas criadas com sucesso! ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTableGenero() {
        String sql = "CREATE TABLE genero(\n" +
                "id INTEGER NOT NULL AUTO_INCREMENT,\n" +
                "nome VARCHAR(40) NOT NULL,\n" +
                "PRIMARY KEY(id));";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("tabela criada com sucessos para generos! ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Genero> generos( Integer id) throws SQLException{
      String sql = "SELECT * FROM filme filme_genero where id = ?";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.setInt(1,id);

      ResultSet rs = stmt.executeQuery();
        List<Genero> generos = new ArrayList<>();

        while(rs.next()){
            Genero genero = new GeneroDao().find(rs.getInt(2));
            generos.add(genero);
        }

        rs.close();
        stmt.close();
        return generos;
    }
    public List<Filme> findAll() throws SQLException {
        String sql = "SELECT * FROM filme";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Filme> filmes = new ArrayList<>();

        while(rs.next()){
            List<Genero> generos = this.generos(rs.getInt(1));
            filmes.add(new Filme(rs.getInt(1), rs.getString(2)));
        }
        rs.close();
        stmt.close();
        return filmes;
    }

}
