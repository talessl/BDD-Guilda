package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Mercadoria;
import model.MercadoriaTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ViewMercadoria extends JFrame {

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
	
	MercadoriaTableModel tableModel = new MercadoriaTableModel();
	private JTextField txtPreco;
	private JTextField txtId;
	private JTextField txtNome;
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
		jTMercadorias.setModel(tableModel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Mercadoria m = new Mercadoria();
				m.setId(Integer.parseInt(txtId.getText()));
				m.setNome_produto(txtNome.getText());
				m.setPreco(Float.parseFloat(txtPreco.getText()));
				m.setRaridade(txtRaridade.getText());
				
				tableModel.addRow(m);
				
			}
		});
		btnSalvar.setBounds(35, 105, 89, 23);
		contentPane.add(btnSalvar);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(356, 38, 97, 20);
		contentPane.add(txtPreco);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(35, 38, 97, 20);
		contentPane.add(txtId);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(142, 38, 97, 20);
		contentPane.add(txtNome);
		
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
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jTMercadorias.getSelectedRow() != -1) {
					
					tableModel.removeRow(jTMercadorias.getSelectedRow());
					
				}
			}
		});
		btnRemover.setBounds(134, 105, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jTMercadorias.getSelectedRow() != -1) {
					tableModel.setValueAt(txtId.getText(),jTMercadorias.getSelectedRow(),0);
					tableModel.setValueAt(txtNome.getText(),jTMercadorias.getSelectedRow(),1);
					tableModel.setValueAt(txtPreco.getText(),jTMercadorias.getSelectedRow(),2);
					tableModel.setValueAt(txtRaridade.getText(),jTMercadorias.getSelectedRow(),3);
					
				}
			}
		});
		btnAlterar.setBounds(233, 105, 89, 23);
		contentPane.add(btnAlterar);
		
		readJTable();
	}
	
	//metodo read JTable
	public void readJTable() { 
		DefaultTableModel modelo = (DefaultTableModel) jTMercadorias.getModel();
		modelo.setNumRows(0);
		
		MercadoriaTableModel mtbm = new MercadoriaTableModel();
		
		for(Mercadoria m: mtbm.read()) {
			
			modelo.addRow(new Object[] {
					m.getId(),
					m.getNome_produto(),
					m.getRaridade(),
					m.getPreco()
					
			});
			
		}
		
	}
	
}
