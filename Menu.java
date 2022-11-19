package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField txtGuilda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtGuilda = new JTextField();
		txtGuilda.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuilda.setText("Guilda");
		txtGuilda.setBounds(225, 66, 86, 20);
		contentPane.add(txtGuilda);
		txtGuilda.setColumns(10);
		
		JButton btnNewButton = new JButton("Mercador");
		btnNewButton.setBounds(82, 157, 113, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Vender");
		btnNewButton_1.setBounds(213, 157, 113, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Mercadoria");
		btnNewButton_1_1.setBounds(336, 157, 113, 40);
		contentPane.add(btnNewButton_1_1);
	}

}
