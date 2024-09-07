package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class HomeOperatore {

	private JFrame frame;

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
		
		JLabel lblNewLabel_1 = new JLabel("Operetors");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(465, 35, 87, 18);
		panel.add(lblNewLabel_1);
		
		JButton btnApriUnConto = new JButton("Apri un conto spesa");
		btnApriUnConto.setForeground(Color.WHITE);
		btnApriUnConto.setFont(new Font("Arial", Font.BOLD, 16));
		btnApriUnConto.setBackground(new Color(39, 174, 96));
		btnApriUnConto.setBounds(196, 246, 381, 44);
		frame.getContentPane().add(btnApriUnConto);
		
		JButton btnNewButton_1 = new JButton("Registrazione pagamento");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1.setBounds(196, 324, 381, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Stampa del conto finale");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1_1.setBounds(196, 400, 381, 44);
		frame.getContentPane().add(btnNewButton_1_1);
	}

}
