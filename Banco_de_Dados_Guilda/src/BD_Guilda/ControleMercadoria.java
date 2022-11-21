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

public class ControleMercadoria {

public void create(Mercadoria mercadoria) throws ClassNotFoundException, SQLException {
        
        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO guilda.mercadoria (id_mercadoria, nome_produto, preco, raridade)"
            		+ " VALUES(?,?,?,?)");
            stmt.setInt(1, mercadoria.getId_mercadoria());
            stmt.setString(2, mercadoria.getNome_produto());
            stmt.setFloat(3, mercadoria.getPreco());
            stmt.setString(4, mercadoria.getRaridade());

            stmt.executeUpdate();

            System.out.println("Mercadoria Salva!");	
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
        	DBfunction.fecharConexao(conn, stmt);
        }

    }
	
	 public List<Mercadoria> read() throws ClassNotFoundException, SQLException {

	        Connection conn = DBfunction.criarConexao();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Mercadoria> lista_mercadorias = new ArrayList<>();

	        try {
	            stmt = conn.prepareStatement("SELECT * FROM guilda.mercadoria");
	            rs = stmt.executeQuery();

	            while (rs.next()) {

	                Mercadoria mercadoria = new Mercadoria();

	                mercadoria.setId_mercadoria(rs.getInt("id_mercadoria"));
	                mercadoria.setNome_produto(rs.getString("nome_produto"));
	                mercadoria.setPreco(rs.getFloat("preco"));
	                mercadoria.setRaridade(rs.getString("raridade"));
	               
	                lista_mercadorias.add(mercadoria);
	            }

	        } catch (SQLException ex) {
	            Logger.getLogger(ControleMercador.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            DBfunction.fecharConexao(conn, stmt, rs);
	        }

	        return lista_mercadorias;

	    }
	 
	 
	 public void update(Mercadoria mercadoria) throws ClassNotFoundException, SQLException {
	        
	        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;

	        try {
	            stmt = conn.prepareStatement("UPDATE guilda.mercadoria SET nome_produto = ?, preco = ?, raridade = ?"
	            		+ " WHERE id_mercadoria = ?");
	            
	            stmt.setString(1, mercadoria.getNome_produto());
	            stmt.setFloat(2, mercadoria.getPreco());
	            stmt.setString(3, mercadoria.getRaridade());
	           
	            stmt.setInt(4, mercadoria.getId_mercadoria());

	            stmt.executeUpdate();

	            System.out.println("Mercadoria Atualizada!");	
	            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
	            
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	        	DBfunction.fecharConexao(conn, stmt);
	        }

	    }
	 
	 
	 public void delete(Mercadoria mercadoria) throws ClassNotFoundException, SQLException {
	        
	        Connection conn = DBfunction.criarConexao();// = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;

	        try {
	            stmt = conn.prepareStatement("DELETE FROM guilda.mercadoria WHERE id_mercadoria = ?");
	            
	            stmt.setInt(1, mercadoria.getId_mercadoria());

	            stmt.executeUpdate();

	            System.out.println("Mercadoria: " + mercadoria.getNome_produto() + " Excluida!");	
	            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
	            
	        } catch (SQLException ex) {
	            System.out.println(ex);
	        } finally {
	        	DBfunction.fecharConexao(conn, stmt);
	        }

	 }
	 
	
}
