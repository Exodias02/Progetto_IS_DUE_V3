package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcquistaServizio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcquistaServizio window = new AcquistaServizio();
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
	public AcquistaServizio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 16));
		frame.getContentPane().setBackground(new Color(44, 62, 80));
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(39, 174, 96));
		panel_1.setBounds(-1, 0, 775, 74);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("LOGO");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(683, 20, 68, 39);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("< Back");
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setForeground(new Color(44, 62, 80));
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1_1.setBounds(10, 20, 102, 34);
		panel_1.add(btnNewButton_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(232, 146, 385, 45);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Scegli il servizio");
		lblNewLabel_1_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(32, 151, 165, 32);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Conto Spesa");
		lblNewLabel_1_1_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(32, 247, 165, 32);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnAcquista = new JButton("ACQUISTA");
		btnAcquista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcquista.setForeground(Color.WHITE);
		btnAcquista.setFont(new Font("Arial", Font.BOLD, 20));
		btnAcquista.setBackground(new Color(39, 174, 96));
		btnAcquista.setBounds(483, 331, 229, 67);
		frame.getContentPane().add(btnAcquista);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Arial", Font.BOLD, 16));
		formattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		formattedTextField.setBounds(232, 242, 154, 37);
		frame.getContentPane().add(formattedTextField);
		frame.setBounds(100, 100, 788, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
