package modelMercador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import connection.ConnectionFactory;

public class MercadorTableModel extends AbstractTableModel {
	
	private List<Mercador> dados = new ArrayList<>();
	private String[] colunas = {"ID", "Nome", "Raça", "Gênero", "Nivel_Maestria"};
	
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
 
	@Override //id nome raca genero nivel
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return dados.get(linha).getId_mercador();
		case 1:
			return dados.get(linha).getNome();
		case 2:
			return dados.get(linha).getRaca();
		case 3: 
			return dados.get(linha).getGenero();
		case 4: 
			return dados.get(linha).getNivel_maestria();
		}
		return null;
		}
	
	
	
		public void setValueAt(Object valor, int linha, int coluna){
			switch (coluna) {
			case 0:
				 dados.get(linha).setId_mercador(Integer.parseInt((String) valor));
				 break;
			case 1:
				 dados.get(linha).setNome((String) valor);
				 break;
			case 2:
				 dados.get(linha).setRaca((String) valor);
				 break;
			case 3: 
				 dados.get(linha).setGenero(((String) valor));
				 break;
			case 4:
				dados.get(linha).setNivel_maestria(Integer.parseInt((String) valor));
				 break;
			}
			
			this.fireTableRowsUpdated(linha, coluna);
		}
	
	
	public void addRow(Mercador m) {
		this.dados.add(m);
		this.fireTableDataChanged();
	}
	
	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
	
	
	//metodo read JTable
	public List<Mercador> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Mercador> mercadores = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM mercadoria");	
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Mercador mercador = new Mercador();
				
				mercador.setId_mercador(rs.getInt("id_mercador"));
				mercador.setNome(rs.getString("nome"));
				mercador.setRaca(rs.getString("raca"));
				mercador.setGenero(rs.getString("genero"));
				mercador.setNivel_maestria(rs.getInt("nivel_maestria"));
				mercadores.add(mercador);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro na conexão..",e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return mercadores;
	}
	
	
}
