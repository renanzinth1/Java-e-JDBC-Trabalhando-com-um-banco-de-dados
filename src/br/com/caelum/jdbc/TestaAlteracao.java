package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaAlteracao {

	public static void main(String[] args) throws SQLException {

		try (Connection conn = Database.getConnection()) {

			try (Statement stmt = conn.createStatement()) {

				stmt.executeUpdate("UPDATE Usuario SET sobrenome = 'Araujo' WHERE id = 13");
				int contaLinhas = stmt.getUpdateCount();

				System.out.println(contaLinhas + " linhas atualizadas");

			} catch (SQLException e) {
				System.out.println("Erro: " + e);
			}
		}
	}
}