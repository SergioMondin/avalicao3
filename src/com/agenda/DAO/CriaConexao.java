package com.agenda.DAO;

/**
 * @author SLM
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CriaConexao {

	public static Connection getConexao() throws FileNotFoundException,
			SQLException {

		// Carregando o Driver JDBC (do RDBMS PostgreSQL)
		// DriverManager.registerDriver(new org.postgresql.Driver());


		Properties p = new Properties();
		try {
			p.load(new FileInputStream("src/config/config.properties"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		String url = p.getProperty("jdbc.url");
		return DriverManager.getConnection(url, p);

		// return DriverManager.getConnection(
		// "jdbc:postgresql://localhost:5432/agendaBD", "postgres",
		// "postgres");

	}

}
