package br.dao;

import br.factory.ConnectionFactory;
import br.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    public Connection connection;

    public UsuarioDao() {
        this.connection = ConnectionFactory.getConnection();
    }
    public List<Usuario> findAll() throws SQLException {
        String sql = "SELECT * FROM usuario";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        // declarando e instanciando uma lista de usuarios
        List<Usuario> usuarios = new ArrayList<>();

        while (rs.next()){
            usuarios.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        rs.close();
        stmt.close();
        connection.close();
        return usuarios;
    }
    public  Usuario find(Integer id){
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Usuario usuario = new Usuario();
            if (rs.next()){
                usuario.setId(rs.getInt(1));
                usuario.setEmail(rs.getString(2));
                usuario.setSenha(rs.getString(3));
            }
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  Usuario create(Usuario usuario){
        String sql = "INSERT INTO usuario (id) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, usuario.getId());
            stmt.executeUpdate();

            ResultSet usuarioGerado = stmt.getGeneratedKeys();

            if(usuarioGerado.next()){
                Integer idUsuario = usuarioGerado.getInt(1);
                usuario.setId(idUsuario);
            }
            stmt.close();
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Usuario update(Usuario usuario){
        String sql = "UPDATE usuario set email=? where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, usuario.getId());
            stmt.setString(2,usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public void delete(Usuario usuario){
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,usuario.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
