package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.caelum.modelo.Usuario;

public class TestaInsercaoDeUsuario {

	public static void main(String[] args) throws SQLException {
		Usuario user = new Usuario(16, "João", "Dias", 18);

		try (Connection conn = Database.getConnection()) {

			String sql = "INSERT INTO Usuario (id, nome, sobrenome, idade) VALUES (?, ?, ?)";
			try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				stmt.setString(1, user.getNome());
				stmt.setString(2, user.getSobrenome());
				stmt.setInt(3, user.getIdade());
				stmt.execute();

				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {
						int id = rs.getInt("id");
						user.setId(id);
					}
				}
			}
		}
	}
}