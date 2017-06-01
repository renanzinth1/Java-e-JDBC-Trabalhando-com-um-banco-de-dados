package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = Database.getConnection()) {
			connection.setAutoCommit(false);

			String sql = "insert into Usuario (id, nome, sobrenome, idade) values (?, ?, ?, ?)";

			try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adiciona(16, "José", "Rodrigo", 21, stmt);
				adiciona(17, "Mauro", "Neves", 18, stmt);
				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback efetuado!");
				connection.rollback();

			}
		}
	}

	private static void adiciona(int id, String nome, String sobrenome, int idade, PreparedStatement stmt)
			throws SQLException {

		stmt.setInt(1, id);
		stmt.setString(2, nome);
		stmt.setString(3, sobrenome);
		stmt.setInt(4, idade);

		boolean resultado = stmt.execute();

		int contaLinhas = stmt.getUpdateCount();
		System.out.println(contaLinhas + " linha atualizada");
	}
}