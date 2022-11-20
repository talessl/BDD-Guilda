package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DRIVER = "com.mysql.jbdc.Driver";
	private static final String URL = "jdbc:mysql://localhost:5432/guilda";
	private static final String USER = "psotgres";
	private static final String PASS = "postgres";
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro na conexão..",e);
		}
		
		}
	
	public static void closeConnection(Connection con) {
	
		try {
			if(con!=null) {
			con.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		
		try {
			
			if(stmt != null) {
				stmt.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		}
	
public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		
		try {
			
			if(stmt != null) {
				stmt.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		}

public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
	
	closeConnection(con, stmt);
	
	try {
		
		if(rs != null) {
			rs.close();
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	}
	}

