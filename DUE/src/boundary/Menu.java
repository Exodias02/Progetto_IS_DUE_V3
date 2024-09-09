package boundary;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	JFrame frame;
	private String result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		result = null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(44, 62, 80));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(39, 174, 96));
		panel.setBounds(0, 0, 775, 74);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Dune Camping");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBackground(new Color(39, 174, 96));
		lblNewLabel.setBounds(296, 10, 176, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Chi sei?");
		lblNewLabel_1_1_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(331, 151, 109, 32);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(256, 200, 254, 45);
		comboBox.addItem("Cliente Registrato");
		comboBox.addItem("Operatore");
		comboBox.addItem("Gestore Campeggio");
		
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Entra come ospite >");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomeOspite window = new HomeOspite();
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton_1.setForeground(new Color(39, 174, 96));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(44, 62, 80));
		btnNewButton_1.setBounds(292, 419, 170, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnAccedi = new JButton("ACCEDI");
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				result = String.valueOf(comboBox.getSelectedItem()); //metodo per ottenere items da comboBox
				
				
				if(result.compareTo("Cliente Registrato") == 0) {

					try {
						HomeClienteRegistrato window = new HomeClienteRegistrato();
						window.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (NumberFormatException e1) {
						System.out.println(e1.getMessage());
					}
				}else if(result.compareTo("Operatore") == 0) {
					try {
						HomeOperatore window = new HomeOperatore();
						window.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (NumberFormatException e1) {
						System.out.println(e1.getMessage());
					}
				}else if (result.compareTo("Gestore Campeggio") == 0) {
					try {
						HomeGestore window = new HomeGestore();
						window.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (NumberFormatException e1) {
						System.out.println(e1.getMessage());
					}
				
				}
				else {
					try {
						HomeClienteRegistrato window = new HomeClienteRegistrato();
						window.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (NumberFormatException e1) {
						System.out.println(e1.getMessage());
					}
					
				}
			}
		});
		btnAccedi.setForeground(Color.WHITE);
		btnAccedi.setFont(new Font("Arial", Font.BOLD, 20));
		btnAccedi.setBackground(new Color(39, 174, 96));
		btnAccedi.setBounds(279, 309, 201, 67);
		frame.getContentPane().add(btnAccedi);
		frame.setBounds(100, 100, 788, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
