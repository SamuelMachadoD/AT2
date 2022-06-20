package br.com.prova.Questao9;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	public DataSource datasource;
	
	public ConnectionFactory() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/PROVA?useTimezone=true&serverTimezone=UTC");
		cpds.setUser("root");
		cpds.setPassword("root");
		this.datasource = cpds;
	}
	
	
	public Connection RecuperaConexão() throws SQLException {
		return this.datasource.getConnection();
		
	}
}
