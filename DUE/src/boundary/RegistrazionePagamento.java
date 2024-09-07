package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class RegistrazionePagamento {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrazionePagamento window = new RegistrazionePagamento();
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
	public RegistrazionePagamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(44, 62, 80));
		frame.getContentPane().setForeground(new Color(44, 62, 80));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(39, 174, 96));
		panel.setBounds(0, 0, 775, 74);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(683, 20, 68, 39);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(new Color(44, 62, 80));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1.setBounds(10, 20, 102, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Conto Spesa");
		lblNewLabel_1_1_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(308, 141, 132, 32);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Arial", Font.BOLD, 16));
		formattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		formattedTextField.setBounds(295, 183, 145, 37);
		frame.getContentPane().add(formattedTextField);
		
		JButton btnRegistra = new JButton("REGISTRA");
		btnRegistra.setForeground(Color.WHITE);
		btnRegistra.setFont(new Font("Arial", Font.BOLD, 20));
		btnRegistra.setBackground(new Color(39, 174, 96));
		btnRegistra.setBounds(267, 293, 201, 67);
		frame.getContentPane().add(btnRegistra);
		frame.setBounds(100, 100, 787, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
