package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BD_Guilda.ControleMercador;
import BD_Guilda.ControleMercadoria;
import BD_Guilda.ControleVende;
import BD_Guilda.Mercador;
import BD_Guilda.Mercadoria;
import BD_Guilda.Vende;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class ViewTelaMercador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7334563974154783193L;
	private JPanel contentPane;
	private JTextField txtId_Mercador;
	private JTextField txtNome;
	private JTextField txtRaca;
	private JTextField txtGenero;
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JLabel lblRaa;
	private JLabel lblGnero;
	private JTextField txtNivel_Maestria;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField txtMercador;
	private JTable jTMercador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaMercador frame = new ViewTelaMercador();
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
	public ViewTelaMercador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 200, 460, 159);
		contentPane.add(scrollPane);
		
		jTMercador = new JTable();
		scrollPane.setViewportView(jTMercador);
		jTMercador.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					
				},
				new String [] {
						"ID", "NOME", "RAÇA", "GÊNERO", "NÍVEL DE MAESTRIA"
				}
				));
		
		DefaultTableModel modelo = (DefaultTableModel) jTMercador.getModel();
		jTMercador.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));
		
		readJTable();
		
		txtId_Mercador = new JTextField();
		txtId_Mercador.setBounds(10, 81, 123, 20);
		contentPane.add(txtId_Mercador);
		txtId_Mercador.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(143, 81, 123, 20);
		contentPane.add(txtNome);
		
		txtRaca = new JTextField();
		txtRaca.setColumns(10);
		txtRaca.setBounds(276, 81, 123, 20);
		contentPane.add(txtRaca);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(10, 137, 123, 20);
		contentPane.add(txtGenero);
		
		lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 62, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(143, 62, 46, 14);
		contentPane.add(lblNome);
		
		lblRaa = new JLabel("Raça");
		lblRaa.setBounds(276, 62, 46, 14);
		contentPane.add(lblRaa);
		
		lblGnero = new JLabel("Gênero");
		lblGnero.setBounds(10, 112, 46, 14);
		contentPane.add(lblGnero);
		
		txtNivel_Maestria = new JTextField();
		txtNivel_Maestria.setColumns(10);
		txtNivel_Maestria.setBounds(143, 137, 123, 20);
		contentPane.add(txtNivel_Maestria);
		
		lblNewLabel_4 = new JLabel("Nível de Maestria");
		lblNewLabel_4.setBounds(143, 112, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ControleMercador ctr_mercador = new ControleMercador();
				Mercador mercador = new Mercador();
				//Insere um mercador de exemplo no banco
				
				mercador.setId_mercador(Integer.parseInt(txtId_Mercador.getText()));
				mercador.setNome(txtNome.getText());
				mercador.setRaca(txtRaca.getText());
				mercador.setGenero(txtGenero.getText());
				mercador.setNivel_maestria(Integer.parseInt(txtNivel_Maestria.getText()));
				
				try {
					ctr_mercador.create(mercador);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercador.setText("");
				txtNome.setText("");
				txtRaca.setText("");
				txtGenero.setText("");
				txtNivel_Maestria.setText("");

		        readJTable();
			}
			
		});
		btnNewButton.setBounds(33, 168, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleMercador ctr_mercador = new ControleMercador();
				Mercador mercador = new Mercador();
				
				mercador.setId_mercador(Integer.parseInt(txtId_Mercador.getText()));
				
				try {
					ctr_mercador.delete(mercador);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercador.setText("");
				txtNome.setText("");
				txtRaca.setText("");
				txtGenero.setText("");
				txtNivel_Maestria.setText("");

		        readJTable();
				
			}
		});
		btnNewButton_1.setBounds(153, 168, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtMercador = new JTextField();
		txtMercador.setHorizontalAlignment(SwingConstants.CENTER);
		txtMercador.setText("Mercador");
		txtMercador.setBounds(10, 22, 150, 29);
		contentPane.add(txtMercador);
		txtMercador.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControleMercador ctr_mercador = new ControleMercador();
				Mercador mercador = new Mercador();
				
				mercador.setId_mercador(Integer.parseInt(txtId_Mercador.getText()));
				mercador.setNome(txtNome.getText());
				mercador.setRaca(txtRaca.getText());
				mercador.setGenero(txtGenero.getText());
				mercador.setNivel_maestria(Integer.parseInt(txtNivel_Maestria.getText()));
				
				try {
					ctr_mercador.update(mercador);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtId_Mercador.setText("");
				txtNome.setText("");
				txtRaca.setText("");
				txtGenero.setText("");
				txtNivel_Maestria.setText("");

		        readJTable();
				
			}
		});
		btnNewButton_2.setBounds(276, 169, 85, 21);
		contentPane.add(btnNewButton_2);
	}
	
	public void readJTable() { 
		DefaultTableModel modelo = (DefaultTableModel) jTMercador.getModel();
		modelo.setNumRows(0);
		
		ControleMercador ctr_mercador = new ControleMercador();
		
		try {
			for(Mercador m: ctr_mercador.read()) {
				
				modelo.addRow(new Object[] {
						m.getId_mercador(),
						m.getNome(),
						m.getRaca(),
						m.getGenero(),
						m.getNivel_maestria()
						
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





