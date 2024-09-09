package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class HomeOspite {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeOspite window = new HomeOspite();
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
	public HomeOspite() {
		initialize();
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
		
		JLabel LOGO = new JLabel("");
		LOGO.setBounds(336, 119, 100, 100);
		ImageIcon i = new ImageIcon(EffettuaPrenotazione.class.getResource("/images/logo.png"));
		Image ok = i.getImage().getScaledInstance(LOGO.getWidth(), LOGO.getHeight(), Image.SCALE_SMOOTH);
		LOGO.setIcon(new ImageIcon(ok));
		LOGO.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(LOGO);
		
		JLabel lblNewLabel = new JLabel("Dune Camping");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBackground(new Color(39, 174, 96));
		lblNewLabel.setBounds(304, 10, 176, 54);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1_2 = new JButton("< Back");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_2.setBackground(new Color(39, 174, 96));
		btnNewButton_1_2.setBounds(10, 22, 102, 34);
		panel.add(btnNewButton_1_2);
		
		JButton btnVisualizzaDisponibilit = new JButton("Visualizza disponibilità");
		btnVisualizzaDisponibilit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					RitornoHome window = new RitornoHome();
					window.setPagina(3);
					window.setMessage("Questa funzione non è al momento disponibile :(");
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				}
				
			}
			
		});
		btnVisualizzaDisponibilit.setForeground(Color.WHITE);
		btnVisualizzaDisponibilit.setFont(new Font("Arial", Font.BOLD, 20));
		btnVisualizzaDisponibilit.setBackground(new Color(39, 174, 96));
		btnVisualizzaDisponibilit.setBounds(191, 253, 401, 61);
		frame.getContentPane().add(btnVisualizzaDisponibilit);
		
		JButton btnNewButton_1 = new JButton("Registrati");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					RitornoHome window = new RitornoHome();
					window.setPagina(3);
					window.setMessage("Questa funzione non è al momento disponibile :(");
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				}
				
			
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1.setBounds(191, 352, 401, 61);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 789, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
