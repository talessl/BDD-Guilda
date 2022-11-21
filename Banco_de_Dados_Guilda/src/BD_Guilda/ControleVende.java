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

public class ControleVende {

public void create(Vende vende) throws ClassNotFoundException, SQLException {
        
        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO guilda.vende (id_mercador, id_mercadoria)"
            		+ " VALUES(?,?)");
            stmt.setInt(1, vende.getId_mercador());
            stmt.setInt(2, vende.getId_mercadoria());

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso!");	
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
        	DBfunction.fecharConexao(conn, stmt);
        }

    }
	
	 public List<Vende> read() throws ClassNotFoundException, SQLException {

	        Connection conn = DBfunction.criarConexao();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Vende> lista_vende = new ArrayList<>();

	        try {
	            stmt = conn.prepareStatement("SELECT * FROM guilda.vende");
	            rs = stmt.executeQuery();

	            while (rs.next()) {

	                Vende vende = new Vende();

	                vende.setId_mercador(rs.getInt("id_mercador"));
	                vende.setId_mercadoria(rs.getInt("id_mercadoria"));
	               
	                lista_vende.add(vende);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ControleMercador.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            DBfunction.fecharConexao(conn, stmt, rs);
	        }

	        return lista_vende;

	    }
	 
	 
	 
	 public List<Vende> readVende() throws ClassNotFoundException, SQLException {

	        Connection conn = DBfunction.criarConexao();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Vende> lista_vende = new ArrayList<>();

	        try {
	            stmt = conn.prepareStatement("SELECT mercador.id_mercador, mercador.nome, mercadoria.nome_produto"
	            		+ " FROM guilda.mercador JOIN guilda.vende ON(mercador.id_mercador = vende.id_mercador)"
	            		+ " JOIN guilda.mercadoria ON(mercadoria.id_mercadoria = vende.id_mercadoria)");
	            rs = stmt.executeQuery();

	            while (rs.next()) {

	                Vende vende = new Vende();

	                vende.setId_mercador(rs.getInt("id_mercador"));
	                vende.setNome_mercador(rs.getString("nome"));
	                vende.setNome_mercadoria(rs.getString("nome_produto"));
	               
	                lista_vende.add(vende);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ControleMercador.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            DBfunction.fecharConexao(conn, stmt, rs);
	        }

	        return lista_vende;

	    }
	 
	 
	 public void update(Vende vende) throws ClassNotFoundException, SQLException {
	        
	        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;

	        try {
	            stmt = conn.prepareStatement("UPDATE guilda.vende SET id_mercadoria = ?"
	            		+ " WHERE id_mercador = ?");
	            
	            stmt.setInt(1, vende.getId_mercadoria());
	            stmt.setInt(2, vende.getId_mercador());

	            stmt.executeUpdate();

	            System.out.println("Atualizado com Sucesso!");	
	            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	            
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	        	DBfunction.fecharConexao(conn, stmt);
	        }

	    }
	 
	 
	 public void delete(Vende vende) throws ClassNotFoundException, SQLException {
	        
	        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;

	        try {
	            stmt = conn.prepareStatement("DELETE FROM guilda.vende WHERE id_mercador = ? AND id_mercadoria = ?");
	            
	            stmt.setInt(1, vende.getId_mercador());
	            stmt.setInt(2, vende.getId_mercadoria());

	            stmt.executeUpdate();

	            System.out.println("Excluido com sucesso!");	
	            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	            
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	        	DBfunction.fecharConexao(conn, stmt);
	        }

	 }
	 
	
	
}
