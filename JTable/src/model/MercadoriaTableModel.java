package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import connection.ConnectionFactory;

public class MercadoriaTableModel extends AbstractTableModel {
	
	private List<Mercadoria> dados = new ArrayList<>();
	private String[] colunas = {"ID", "Nome", "Raridade", "Preço"};
	
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return dados.get(linha).getId();
		case 1:
			return dados.get(linha).getNome_produto();
		case 2:
			return dados.get(linha).getRaridade();
		case 3: 
			return dados.get(linha).getPreco();
		}
		return null;
		}
	
	
	
		public void setValueAt(Object valor, int linha, int coluna){
			switch (coluna) {
			case 0:
				 dados.get(linha).setId(Integer.parseInt((String) valor));
				 break;
			case 1:
				 dados.get(linha).setNome_produto((String) valor);
				 break;
			case 2:
				 dados.get(linha).setRaridade((String) valor);
				 break;
			case 3: 
				 dados.get(linha).setPreco(Float.parseFloat((String) valor));
				 break;
			}
			
			this.fireTableRowsUpdated(linha, coluna);
		}
	
	
	public void addRow(Mercadoria m) {
		this.dados.add(m);
		this.fireTableDataChanged();
	}
	
	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
	
	
	//metodo read JTable
	public List<Mercadoria> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Mercadoria> mercadorias = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM mercadoria");	
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Mercadoria mercadoria = new Mercadoria();
				
				mercadoria.setId(rs.getInt("id_mercadoria"));
				mercadoria.setNome_produto(rs.getString("nome_produto"));
				mercadoria.setRaridade(rs.getString("raridade"));
				mercadoria.setPreco(rs.getFloat("preco"));
				mercadorias.add(mercadoria);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro na conexão..",e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return mercadorias;
	}
	
	
}
