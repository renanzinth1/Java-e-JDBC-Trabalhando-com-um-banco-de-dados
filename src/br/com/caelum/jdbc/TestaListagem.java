package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = Database.getConnection()) {

			try (Statement statement = connection.createStatement()) {

				statement.execute("select * from Usuario");

				try (ResultSet resultSet = statement.getResultSet()) {

					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String sobrenome = resultSet.getString("sobrenome");
						int idade = resultSet.getInt("idade");
						System.out.println("\nID: " + id + " Nome: " + nome + " " + sobrenome + " \nIdade: " + idade);
					}
				}
			}
		}
	}
}