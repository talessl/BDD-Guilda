package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ViewPrimeiraTela extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtMercadoira;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrimeiraTela frame = new ViewPrimeiraTela();
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
	public ViewPrimeiraTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 101, 172, 27);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setBounds(10, 76, 46, 14);
		contentPane.add(LabelNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(192, 101, 172, 27);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(374, 101, 172, 27);
		contentPane.add(textField_1);
		
		JLabel LabelPreco = new JLabel("Preço");
		LabelPreco.setBounds(192, 76, 46, 14);
		contentPane.add(LabelPreco);
		
		JLabel LabelRaridade = new JLabel("Raridade");
		LabelRaridade.setBounds(374, 76, 46, 14);
		contentPane.add(LabelRaridade);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(33, 196, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(149, 196, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(275, 196, 89, 23);
		contentPane.add(btnAtualizar);
		
		txtMercadoira = new JTextField();
		txtMercadoira.setHorizontalAlignment(SwingConstants.CENTER);
		txtMercadoira.setText("Mercadoria");
		txtMercadoira.setBounds(10, 11, 198, 27);
		contentPane.add(txtMercadoira);
		txtMercadoira.setColumns(10);
	}
}
