package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = Database.getConnection()) {
			
			try (Statement statement = connection.createStatement()) {
				
				statement.executeUpdate("delete from Usuario where id > 15");
				System.out.println("O usuário foi removido com sucesso!");
				
				int updateCount = statement.getUpdateCount();
				System.out.println(updateCount + " linhas atualizadas");
			}
		}
	}
}
