package BD_Guilda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DBfunction {
	
	static final String DBName = "guilda";
	static final String URL = "jdbc:postgresql://localhost:5432/"+DBName;
	static final String USER = "postgres";
	static final String PASS = "postgres";
	
	public static Connection criarConexao() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection conecta = DriverManager.getConnection(URL, USER, PASS);
		if(conecta != null) {
			System.out.println("Conexão efetuada com sucesso...");
			return conecta;
		}
		else {
			System.out.println("Conexão não foi efetuada...");
		}
		return null;
	}
	
	public static void fecharConexao(Connection conn) throws SQLException {
		
		try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBfunction.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
	
	public static void fecharConexao(Connection conn, PreparedStatement stmt) {
		
		try {
			fecharConexao(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBfunction.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}

	public static void fecharConexao(Connection conn, PreparedStatement stmt, ResultSet rs) {
		
		 fecharConexao(conn, stmt);

	        try {

	            if (rs != null) {
	                rs.close();
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(DBfunction.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}
	
	/*
	public void insert_mercador(Connection conn, int id_mercador, String nome, String raca, String genero, int nivel_maestria) {
		Statement statement;
		
		try {
			
			String query = String.format("INSERT INTO guilda.mercador"
					+ " (id_mercador, nome, raca, genero, nivel_maestria) VALUES (%d, '%s', '%s', '%s', %d)", id_mercador, nome, raca, genero, nivel_maestria);
			statement = conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Mercador inserido");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	
}







