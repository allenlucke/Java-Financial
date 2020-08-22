package main.java.com.Allen.Financial.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {

	private static final String DATASOURCE = "jbdc/finances";
	
	//Closing connection objects, ignoring null provided parameters
	private void cleanUpConnection(Connection conn, CallableStatement cs, ResultSet rs) {
		final String methodName = "cleanUpConnection()";
		try {
			if(conn!=null)
				conn.close();
		}
		catch(SQLException e){
			
		}
		try {
			if(cs != null)
				cs.close();
		}
		catch(SQLException e) {
			
		}
		try {
			if(rs != null)
				rs.close();
		}
		catch(SQLException e) {
			
		}
	}
	
	//Opens connection to the jbdc defined by DATASOURCE
	private Connection createConnection() throws NamingException, SQLException {
		final Context ctx = new InitialContext();
		final DataSource ds = (DataSource) ctx.lookup(DATASOURCE);
		final Connection conn = ds.getConnection();
		
		return conn;
	}
}
