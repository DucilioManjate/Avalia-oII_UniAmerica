package br.dao;

import br.factory.ConnectionFactory;
import br.model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {
    private Connection connection;

    public GeneroDao(){
        this.connection = ConnectionFactory.getConnection();
        this.createTableGenero();
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

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Genero> findAll() throws SQLException {
        String sql = "SELECT * FROM genero";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Genero> generos = new ArrayList<>();

        while(rs.next()){
            generos.add(new Genero(rs.getInt(1), rs.getString(2)));
        }

        rs.close();
        stmt.close();
        return generos;
    }
    public Genero find(Integer id){
        String sql = "SELECT * FROM genero WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            Genero genero = new Genero();

            if(rs.next()){
                genero.setId(rs.getInt(1));
                genero.setNome(rs.getString(2));
            }

            return genero;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
