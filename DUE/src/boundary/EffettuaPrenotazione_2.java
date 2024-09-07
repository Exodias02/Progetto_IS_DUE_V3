package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EffettuaPrenotazione_2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EffettuaPrenotazione_2 window = new EffettuaPrenotazione_2();
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
	public EffettuaPrenotazione_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(44, 62, 80));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 788, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Data Inizio");
		lblNewLabel_1_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(100, 126, 104, 32);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Data Fine");
		lblNewLabel_1_1_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(431, 126, 92, 32);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Piazzola Prenotata");
		lblNewLabel_1_1_2.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(100, 191, 157, 32);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Cliente");
		lblNewLabel_1_1_2_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_2_1.setBounds(100, 261, 76, 32);
		frame.getContentPane().add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Costo della Prenotazione");
		lblNewLabel_1_1_2_1_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_1.setBounds(494, 191, 203, 32);
		frame.getContentPane().add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Procedi al pagamento");
		lblNewLabel_1_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_2.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_2_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_2_1_2.setBounds(282, 323, 241, 32);
		frame.getContentPane().add(lblNewLabel_1_1_2_1_2);
		
		JButton btnNewButton = new JButton("AVANTI");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(39, 174, 96));
		btnNewButton.setBounds(431, 365, 133, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAnnulla = new JButton("ANNULLA");
		btnAnnulla.setForeground(Color.WHITE);
		btnAnnulla.setFont(new Font("Arial", Font.BOLD, 16));
		btnAnnulla.setBackground(new Color(39, 174, 96));
		btnAnnulla.setBounds(243, 365, 133, 44);
		frame.getContentPane().add(btnAnnulla);
		
		textField = new JTextField();
		textField.setText("\r\n");
		textField.setFont(new Font("Arial", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBounds(527, 126, 170, 32);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("\r\n");
		textField_1.setFont(new Font("Arial", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(214, 127, 170, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("\r\n");
		textField_2.setFont(new Font("Arial", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(267, 191, 170, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("\r\n");
		textField_3.setFont(new Font("Arial", Font.BOLD, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(517, 233, 146, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("\r\n");
		textField_4.setFont(new Font("Arial", Font.BOLD, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(186, 261, 295, 32);
		frame.getContentPane().add(textField_4);
	}
}
