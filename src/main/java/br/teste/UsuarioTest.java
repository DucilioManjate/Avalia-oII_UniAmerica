package br.teste;

import br.dao.UsuarioDao;
import br.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioTest {

	public static void main(String[] args) throws SQLException {
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.findAll();//deve retornar uma lista do tipo  Usuario
//        Usuario usuario = usuarioDao.findById(1); // deve buscar no banco de dados pelo Id e retornar uma instancia do tipo Usuario
		for (Usuario user : usuarios){
			System.out.println(user);
		}

	}

}
