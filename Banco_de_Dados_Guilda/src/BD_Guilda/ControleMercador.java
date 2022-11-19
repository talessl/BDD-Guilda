package BD_Guilda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ControleMercador {
	
	public void create(Mercador mercador) throws ClassNotFoundException, SQLException {
        
        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO guilda.mercador (id_mercador, nome, raca, genero, nivel_maestria)"
            		+ " VALUES(?,?,?,?,?)");
            stmt.setInt(1, mercador.getId_mercador());
            stmt.setString(2, mercador.getNome());
            stmt.setString(3, mercador.getRaca());
            stmt.setString(4, mercador.getGenero());
            stmt.setInt(5, mercador.getNivel_maestria());

            stmt.executeUpdate();

            System.out.println("Mercador Salvo!");	
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
        	DBfunction.fecharConexao(conn, stmt);
        }

    }
	
	 public List<Mercador> read() throws ClassNotFoundException, SQLException {

	        Connection conn = DBfunction.criarConexao();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Mercador> lista_mercadores = new ArrayList<>();

	        try {
	            stmt = conn.prepareStatement("SELECT * FROM guilda.mercador");
	            rs = stmt.executeQuery();

	            while (rs.next()) {

	                Mercador mercador = new Mercador();

	                mercador.setId_mercador(rs.getInt("id_mercador"));
	                mercador.setNome(rs.getString("nome"));
	                mercador.setRaca(rs.getString("raca"));
	                mercador.setGenero(rs.getString("genero"));
	                mercador.setNivel_maestria(rs.getInt("nivel_maestria"));
	                lista_mercadores.add(mercador);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ControleMercador.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            DBfunction.fecharConexao(conn, stmt, rs);
	        }

	        return lista_mercadores;

	    }
	 
	 
	 public void update(Mercador mercador) throws ClassNotFoundException, SQLException {
	        
	        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;

	        try {
	            stmt = conn.prepareStatement("UPDATE guilda.mercador SET nome = ?, raca = ?, genero = ?, nivel_maestria = ?"
	            		+ " WHERE id_mercador = ?");
	            
	            stmt.setString(1, mercador.getNome());
	            stmt.setString(2, mercador.getRaca());
	            stmt.setString(3, mercador.getGenero());
	            stmt.setInt(4, mercador.getNivel_maestria());
	            stmt.setInt(5, mercador.getId_mercador());

	            stmt.executeUpdate();

	            System.out.println("Mercador Atualizado!");	
	            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	            
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	        	DBfunction.fecharConexao(conn, stmt);
	        }

	    }
	 
	 
	 public void delete(Mercador mercador) throws ClassNotFoundException, SQLException {
	        
	        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;

	        try {
	            stmt = conn.prepareStatement("DELETE FROM guilda.mercador WHERE id_mercador = ?");
	            
	            stmt.setInt(1, mercador.getId_mercador());

	            stmt.executeUpdate();

	            System.out.println("Mercador: " + mercador.getNome() + " Excluido!");	
	            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	            
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	        	DBfunction.fecharConexao(conn, stmt);
	        }

	    }
	 
	
}










