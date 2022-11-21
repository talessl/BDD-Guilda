package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BD_Guilda.Mercadoria;
import BD_Guilda.ControleMercadoria;

//import MercadoriaTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewMercadoria extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3683104332427962580L;
	private JPanel contentPane;
	private JTable jTMercadorias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMercadoria frame = new ViewMercadoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//MercadoriaTableModel tableModel = new MercadoriaTableModel();
	private JTextField txtPreco;
	private JTextField txtId_Mercadoria;
	private JTextField txtNome_Produto;
	private JTextField txtRaridade;
	
	public ViewMercadoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 176, 460, 159);
		contentPane.add(scrollPane);
		
		jTMercadorias = new JTable();
		scrollPane.setViewportView(jTMercadorias);
		jTMercadorias.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					
				},
				new String [] {
						"ID", "NOME", "PREÇO", "RARIDADE"
				}
				));
		
		DefaultTableModel modelo = (DefaultTableModel) jTMercadorias.getModel();
		jTMercadorias.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
		readJTable();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleMercadoria ctr_mercadoria = new ControleMercadoria();
				Mercadoria mercadoria = new Mercadoria();
				//Insere uma mercadoria no banco
				
				mercadoria.setId_mercadoria(Integer.parseInt(txtId_Mercadoria.getText()));
				mercadoria.setNome_produto(txtNome_Produto.getText());
				mercadoria.setRaridade(txtRaridade.getText());
				mercadoria.setPreco(Float.parseFloat(txtPreco.getText()));
				
				
				try {
					ctr_mercadoria.create(mercadoria);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercadoria.setText("");
				txtNome_Produto.setText("");
				txtRaridade.setText("");
				txtPreco.setText("");

		        readJTable();
				
			}
		});
		btnCadastrar.setBounds(35, 86, 89, 23);
		contentPane.add(btnCadastrar);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(356, 38, 97, 20);
		contentPane.add(txtPreco);
		
		txtId_Mercadoria = new JTextField();
		txtId_Mercadoria.setColumns(10);
		txtId_Mercadoria.setBounds(35, 38, 97, 20);
		contentPane.add(txtId_Mercadoria);
		
		txtNome_Produto = new JTextField();
		txtNome_Produto.setColumns(10);
		txtNome_Produto.setBounds(142, 38, 97, 20);
		contentPane.add(txtNome_Produto);
		
		txtRaridade = new JTextField();
		txtRaridade.setColumns(10);
		txtRaridade.setBounds(249, 38, 97, 20);
		contentPane.add(txtRaridade);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(35, 13, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(142, 13, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblRaridade = new JLabel("Raridade");
		lblRaridade.setBounds(249, 13, 77, 14);
		contentPane.add(lblRaridade);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setBounds(356, 13, 46, 14);
		contentPane.add(lblPreco);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleMercadoria ctr_mercadoria = new ControleMercadoria();
				Mercadoria mercadoria = new Mercadoria();
				
				mercadoria.setId_mercadoria(Integer.parseInt(txtId_Mercadoria.getText()));
				
				
				try {
					ctr_mercadoria.delete(mercadoria);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercadoria.setText("");
				txtNome_Produto.setText("");
				txtPreco.setText("");
				txtRaridade.setText("");

		        readJTable();
				
			}
		});
		btnExcluir.setBounds(134, 86, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleMercadoria ctr_mercadoria = new ControleMercadoria();
				Mercadoria mercadoria = new Mercadoria();
				
				mercadoria.setId_mercadoria(Integer.parseInt(txtId_Mercadoria.getText()));
				mercadoria.setNome_produto(txtNome_Produto.getText());
				mercadoria.setPreco(Float.parseFloat(txtPreco.getText()));
				mercadoria.setRaridade(txtRaridade.getText());
				
				try {
					ctr_mercadoria.update(mercadoria);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercadoria.setText("");
				txtNome_Produto.setText("");
				txtPreco.setText("");
				txtRaridade.setText("");

		        readJTable();
				
				
			}
		});
		btnAtualizar.setBounds(237, 86, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Acessar Menu 

				dispose();
				ViewMenu viewMenu = new ViewMenu();
				viewMenu.setVisible(true);
				
			}
		});
		btnMenu.setBounds(449, 0, 85, 21);
		contentPane.add(btnMenu);
		
		JLabel lblNewLabel = new JLabel("Mercadoria");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(202, 134, 114, 32);
		contentPane.add(lblNewLabel);
		
		//readJTable();
	}
	
	//metodo read JTable
	
	public void readJTable() { 
		DefaultTableModel modelo = (DefaultTableModel) jTMercadorias.getModel();
		modelo.setNumRows(0);
		
		ControleMercadoria ctr_mercadoria = new ControleMercadoria();
		
		try {
			for(Mercadoria m: ctr_mercadoria.read()) {
				
				modelo.addRow(new Object[] {
						m.getId_mercadoria(),
						m.getNome_produto(),
						m.getPreco(),
						m.getRaridade()
						
				});
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}