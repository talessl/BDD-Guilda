package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ViewTelaVende extends JFrame {

	private JPanel contentPane;
	private JTextField txtVenda;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblIdDaMercadoria;
	private JButton btnNewButton;
	private JButton btnAtualizar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaVende frame = new ViewTelaVende();
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
	public ViewTelaVende() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtVenda = new JTextField();
		txtVenda.setText("Vende");
		txtVenda.setHorizontalAlignment(SwingConstants.CENTER);
		txtVenda.setBounds(30, 23, 153, 27);
		contentPane.add(txtVenda);
		txtVenda.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(30, 96, 133, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(237, 96, 133, 20);
		contentPane.add(textField_1);
		
		lblNewLabel = new JLabel("ID do Mercador");
		lblNewLabel.setBounds(30, 82, 104, 14);
		contentPane.add(lblNewLabel);
		
		lblIdDaMercadoria = new JLabel("ID da Mercadoria");
		lblIdDaMercadoria.setBounds(237, 82, 109, 14);
		contentPane.add(lblIdDaMercadoria);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(30, 146, 89, 23);
		contentPane.add(btnNewButton);
		
		btnAtualizar = new JButton("Excluir");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setBounds(161, 146, 89, 23);
		contentPane.add(btnAtualizar);
		
		btnExcluir = new JButton("Atualizar");
		btnExcluir.setBounds(296, 146, 89, 23);
		contentPane.add(btnExcluir);
	}
}
