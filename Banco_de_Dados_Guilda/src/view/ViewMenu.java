package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4755394644691644344L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenu frame = new ViewMenu();
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
	public ViewMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenu.setBounds(174, 43, 71, 22);
		contentPane.add(lblMenu);
		
		JButton btnAcessoMercadoria = new JButton("Mercadoria");
		btnAcessoMercadoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewMercadoria viewMercadoria = new ViewMercadoria();
				viewMercadoria.setVisible(true);
			}
		});
		btnAcessoMercadoria.setBounds(37, 124, 105, 41);
		contentPane.add(btnAcessoMercadoria);
		
		JButton btnAcessoVenda = new JButton("Venda");
		btnAcessoVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewVende viewVende = new ViewVende();
				viewVende.setVisible(true);
			}
		});
		btnAcessoVenda.setBounds(167, 124, 89, 41);
		contentPane.add(btnAcessoVenda);
		
		
		JButton btnAcessoMercador = new JButton("Mercador");
		btnAcessoMercador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewTelaMercador viewTelaMercador = new ViewTelaMercador();
				viewTelaMercador.setVisible(true);
			}
		});
		btnAcessoMercador.setBounds(283, 124, 89, 41);
		contentPane.add(btnAcessoMercador);
	}
}