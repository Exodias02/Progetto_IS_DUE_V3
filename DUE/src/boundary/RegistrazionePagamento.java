package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import database.ContiSpeseDAO;
import entity.ContoSpese;
import exception.DAOException;
import exception.DBConnectionException;

public class RegistrazionePagamento {

	JFrame frame;
	private JFormattedTextField formattedTextField;

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
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(44, 62, 80));
		frame.getContentPane().setForeground(new Color(44, 62, 80));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(39, 174, 96));
		panel.setBounds(0, 0, 775, 74);
		frame.getContentPane().add(panel);
		
		JLabel LOGO = new JLabel("");
		LOGO.setBounds(692, 7, 60, 60);
		ImageIcon i = new ImageIcon(EffettuaPrenotazione.class.getResource("/images/logo.png"));
		Image ok = i.getImage().getScaledInstance(LOGO.getWidth(), LOGO.getHeight(), Image.SCALE_SMOOTH);
		LOGO.setIcon(new ImageIcon(ok));
		LOGO.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(LOGO);
		
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomeOperatore window = new HomeOperatore();
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1.setBounds(10, 20, 102, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Conto Spesa");
		lblNewLabel_1_1_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(308, 148, 132, 32);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Arial", Font.BOLD, 16));
		formattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		formattedTextField.setBounds(295, 190, 153, 37);
		frame.getContentPane().add(formattedTextField);
		
		JButton btnRegistra = new JButton("REGISTRA");
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formattedTextField == null || formattedTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Devi compilare tutti i campi!");
					return;
				}
				
				int csid = -1;
				
				try {
					csid = Integer.parseInt(formattedTextField.getText());
				}catch(Exception exx) {
					JOptionPane.showMessageDialog(null, "Devi inserire un numero intero!");
					return;
				}
				
				ContoSpese c;
				
				try {
					c = ContiSpeseDAO.readContoSpese(csid);
				} catch (DAOException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
					e1.printStackTrace();
					return;
				} catch (DBConnectionException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
					e1.printStackTrace();
					return;
				}
				
				if(c==null) {
					JOptionPane.showMessageDialog(null, "Non è stato possibile trovare il conto");
					return;
				}
				
				try {
					RegistraPagamento_2 window = new RegistraPagamento_2(c);
					window.frame.setVisible(true);
					frame.setVisible(false);
				} catch (NumberFormatException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnRegistra.setForeground(Color.WHITE);
		btnRegistra.setFont(new Font("Arial", Font.BOLD, 20));
		btnRegistra.setBackground(new Color(39, 174, 96));
		btnRegistra.setBounds(282, 292, 182, 54);
		frame.getContentPane().add(btnRegistra);
		frame.setBounds(100, 100, 787, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
