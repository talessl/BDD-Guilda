package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class ViewTelaMercador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JLabel lblRaa;
	private JLabel lblGnero;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField txtMercador;
	private JTable table;

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
		
		textField = new JTextField();
		textField.setBounds(10, 81, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 81, 123, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(276, 81, 123, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 137, 123, 20);
		contentPane.add(textField_3);
		
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(143, 137, 123, 20);
		contentPane.add(textField_4);
		
		lblNewLabel_4 = new JLabel("Nível de Maestria");
		lblNewLabel_4.setBounds(143, 112, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(33, 168, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(153, 168, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.setBounds(276, 168, 89, 23);
		contentPane.add(btnNewButton_2);
		
		txtMercador = new JTextField();
		txtMercador.setHorizontalAlignment(SwingConstants.CENTER);
		txtMercador.setText("Mercador");
		txtMercador.setBounds(10, 22, 150, 29);
		contentPane.add(txtMercador);
		txtMercador.setColumns(10);
		
		table = new JTable();
		
		table.setBounds(10, 215, 525, 125);
		contentPane.add(table);
	}

}
