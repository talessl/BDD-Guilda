package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BD_Guilda.ControleVende;
import BD_Guilda.Vende;

import javax.swing.JButton;
import java.awt.Font;

public class ViewVende extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2617762838524392987L;
	private JPanel contentPane;
	private JTextField txtId_Mercador;
	private JTextField txtId_Mercadoria;
	private JLabel lblNewLabel;
	private JLabel lblIdDaMercadoria;
	private JButton btnNewButton;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JTable jTVende;
	private JButton btnMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewVende frame = new ViewVende();
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
	public ViewVende() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 176, 460, 159);
		contentPane.add(scrollPane);
		
		jTVende = new JTable();
		scrollPane.setViewportView(jTVende);
		jTVende.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					
				},
				new String [] {
						"ID", "MERCADOR", "PRODUTO"
				}
				));
		
		DefaultTableModel modelo = (DefaultTableModel) jTVende.getModel();
		jTVende.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
		readJTable();
		
		txtId_Mercador = new JTextField();
		txtId_Mercador.setBounds(30, 96, 133, 20);
		contentPane.add(txtId_Mercador);
		txtId_Mercador.setColumns(10);
		
		txtId_Mercadoria = new JTextField();
		txtId_Mercadoria.setColumns(10);
		txtId_Mercadoria.setBounds(237, 96, 133, 20);
		contentPane.add(txtId_Mercadoria);
		
		lblNewLabel = new JLabel("ID do Mercador");
		lblNewLabel.setBounds(30, 82, 104, 14);
		contentPane.add(lblNewLabel);
		
		lblIdDaMercadoria = new JLabel("ID da Mercadoria");
		lblIdDaMercadoria.setBounds(237, 82, 109, 14);
		contentPane.add(lblIdDaMercadoria);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleVende ctr_vende = new ControleVende();
				Vende vende = new Vende();
				//Insere uma mercadoria no banco
				
				vende.setId_mercador(Integer.parseInt(txtId_Mercador.getText()));
				vende.setId_mercadoria(Integer.parseInt(txtId_Mercadoria.getText()));
				
				
				try {
					ctr_vende.create(vende);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercador.setText("");
				txtId_Mercadoria.setText("");

		        readJTable();
				
				
			}
		});
		btnNewButton.setBounds(30, 146, 89, 23);
		contentPane.add(btnNewButton);
		
		btnAtualizar = new JButton("Excluir");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleVende ctr_vende = new ControleVende();
				Vende vende = new Vende();
				
				vende.setId_mercador(Integer.parseInt(txtId_Mercador.getText()));
				vende.setId_mercadoria(Integer.parseInt(txtId_Mercadoria.getText()));
				
				try {
					ctr_vende.delete(vende);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercador.setText("");
				txtId_Mercadoria.setText("");

		        readJTable();
				
				
			}
		});
		btnAtualizar.setBounds(161, 146, 89, 23);
		contentPane.add(btnAtualizar);
		
		btnExcluir = new JButton("Atualizar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleVende ctr_vende = new ControleVende();
				Vende vende = new Vende();
				
				vende.setId_mercador(Integer.parseInt(txtId_Mercador.getText()));
				vende.setId_mercadoria(Integer.parseInt(txtId_Mercadoria.getText()));
				
				try {
					ctr_vende.update(vende);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercador.setText("");
				txtId_Mercadoria.setText("");

		        readJTable();
				
				
				
			}
		});
		btnExcluir.setBounds(296, 146, 89, 23);
		contentPane.add(btnExcluir);
		
		btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Acessar Menu 

				dispose();
				ViewMenu viewMenu = new ViewMenu();
				viewMenu.setVisible(true);
				
			}
		});
		btnMenu.setBounds(435, 10, 85, 21);
		contentPane.add(btnMenu);
		
		JLabel lblNewLabel_1 = new JLabel("Tela Vende");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(62, 28, 127, 23);
		contentPane.add(lblNewLabel_1);
	}
	

	public void readJTable() { 
		DefaultTableModel modelo = (DefaultTableModel) jTVende.getModel();
		modelo.setNumRows(0);
		
		ControleVende ctr_vende = new ControleVende();
		
		try {
			for(Vende m: ctr_vende.readVende()) {
				
				modelo.addRow(new Object[] {
						m.getId_mercador(),
						m.getNome_mercador(),
						m.getNome_mercadoria()
						
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



