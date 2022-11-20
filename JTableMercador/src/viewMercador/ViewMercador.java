package viewMercador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Mercadoria;
import model.MercadoriaTableModel;
import modelMercador.Mercador;
import modelMercador.MercadorTableModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ViewMercador extends JFrame {

	private JPanel contentPane;
	private JTextField txtId_mercador;
	private JTextField txtNomeMercador;
	private JTextField txtRaca;
	private JTextField txtGenero;
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JLabel lblRaa;
	private JLabel lblGnero;
	private JTextField txtNivel_maestria;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMercador frame = new ViewMercador();
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
	
	MercadorTableModel tableModel = new MercadorTableModel();
	private JScrollPane scrollPane;
	private JLabel lblMercador;
	
	public ViewMercador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId_mercador = new JTextField();
		txtId_mercador.setBounds(10, 81, 123, 20);
		contentPane.add(txtId_mercador);
		txtId_mercador.setColumns(10);
		
		txtNomeMercador = new JTextField();
		txtNomeMercador.setColumns(10);
		txtNomeMercador.setBounds(143, 81, 123, 20);
		contentPane.add(txtNomeMercador);
		
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
		
		txtNivel_maestria = new JTextField();
		txtNivel_maestria.setColumns(10);
		txtNivel_maestria.setBounds(143, 137, 123, 20);
		contentPane.add(txtNivel_maestria);
		
		lblNewLabel_4 = new JLabel("Nível de Maestria");
		lblNewLabel_4.setBounds(143, 112, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//metodo cadastrar 
				
				
			}
		});
		btnNewButton.setBounds(33, 168, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//metodo excluir
				
			}
		});
		btnNewButton_1.setBounds(153, 168, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//metodo atualizar
			}
		});
		btnNewButton_2.setBounds(276, 168, 89, 23);
		contentPane.add(btnNewButton_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 525, 125);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblMercador = new JLabel("Mercador");
		lblMercador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMercador.setBounds(33, 21, 123, 30);
		contentPane.add(lblMercador);
	}
	
	public void readJTable() { 
		DefaultTableModel modelo = (DefaultTableModel) table.getModel(); //table equivale a variavel jTMercadorias (JTable de Mercadorias) 
		modelo.setNumRows(0);
		
		MercadorTableModel mtbm = new MercadorTableModel();
		
		for(Mercador m: mtbm.read()) {
			
			modelo.addRow(new Object[] {
					m.getId_mercador(),
					m.getNome(),
					m.getRaca(),
					m.getGenero(),
					m.getNivel_maestria()
					
			});
			
		}
		
	}

}
