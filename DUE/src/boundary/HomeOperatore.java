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

public class HomeOperatore {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeOperatore window = new HomeOperatore();
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
	public HomeOperatore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(44, 62, 80));
		frame.setBounds(100, 100, 788, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblNewLabel.setBounds(293, 10, 179, 54);
		panel.add(lblNewLabel);
		
		JLabel LOGO = new JLabel("");
		LOGO.setBounds(338, 125, 100, 100);
		ImageIcon i = new ImageIcon(EffettuaPrenotazione.class.getResource("/images/logo.png"));
		Image ok = i.getImage().getScaledInstance(LOGO.getWidth(), LOGO.getHeight(), Image.SCALE_SMOOTH);
		LOGO.setIcon(new ImageIcon(ok));
		LOGO.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(LOGO);
		
		JLabel lblNewLabel_1 = new JLabel("Operators");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(465, 35, 87, 18);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_2 = new JButton("< LogOut");
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
		
		JButton btnApriUnConto = new JButton("Apri un conto spesa");
		btnApriUnConto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					RitornoHome window = new RitornoHome();
					window.setPagina(2);
					window.setMessage("Questa funzione non è al momento disponibile :(");
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		btnApriUnConto.setForeground(Color.WHITE);
		btnApriUnConto.setFont(new Font("Arial", Font.BOLD, 16));
		btnApriUnConto.setBackground(new Color(39, 174, 96));
		btnApriUnConto.setBounds(196, 265, 381, 44);
		frame.getContentPane().add(btnApriUnConto);
		
		JButton btnNewButton_1 = new JButton("Registrazione pagamento");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					RegistrazionePagamento window = new RegistrazionePagamento();
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				}
				
			
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1.setBounds(196, 343, 381, 44);
		frame.getContentPane().add(btnNewButton_1);
	}

}
