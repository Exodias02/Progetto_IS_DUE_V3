package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import control.GestioneCampeggio;
import database.ServizioDAO;
import entity.Servizio;
import exception.DAOException;
import exception.DBConnectionException;
import exception.OperationException;

public class AcquistaServizio {

	JFrame frame;
	ArrayList<String> result = null;
	private JFormattedTextField formattedTextField;
	
	private static ArrayList<Servizio> serviziEsistenti;

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
		result = null;
		//formattedTextField.set;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 16));
		frame.getContentPane().setBackground(new Color(44, 62, 80));
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(39, 174, 96));
		panel_1.setBounds(-1, 0, 775, 74);
		frame.getContentPane().add(panel_1);
		
		JLabel LOGO = new JLabel("");
		LOGO.setBounds(692, 7, 60, 60);
		ImageIcon i = new ImageIcon(EffettuaPrenotazione.class.getResource("/images/logo.png"));
		Image ok = i.getImage().getScaledInstance(LOGO.getWidth(), LOGO.getHeight(), Image.SCALE_SMOOTH);
		LOGO.setIcon(new ImageIcon(ok));
		LOGO.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(LOGO);
		
		JButton btnNewButton_1_1 = new JButton("< Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomeClienteRegistrato window = new HomeClienteRegistrato();
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
				}
			}
		});
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1_1.setBounds(10, 20, 102, 34);
		panel_1.add(btnNewButton_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(232, 146, 385, 45);
		
		serviziEsistenti = new ArrayList<Servizio>();
		
		try {
			serviziEsistenti = ServizioDAO.getServizi();
			for(Servizio s : serviziEsistenti) {
				comboBox.addItem(s.getTipoServizio() + " - " + s.getPrezzoServizio() + " €");
			}
		} catch (DAOException | DBConnectionException e1) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
			return;
		}
		
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
		formattedTextField.setFont(new Font("Arial", Font.BOLD, 16));
		formattedTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		formattedTextField.setBounds(232, 242, 154, 37);
		frame.getContentPane().add(formattedTextField);
		frame.setBounds(100, 100, 788, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAcquista = new JButton("ACQUISTA");
		btnAcquista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formattedTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Devi riempire tutti i campi!");
					return;
				}
				try {
					try {
						GestioneCampeggio.getInstance().AcquistaServizio(
								Integer.parseInt(formattedTextField.getText()),
								serviziEsistenti.get(comboBox.getSelectedIndex()).getIdServizio()
						);
					} catch (OperationException e1) {
						JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
						return;
					}
					
					RitornoHome window = new RitornoHome();
					window.setPagina(1);
					window.frame.setVisible(true);
					window.setMessage("Acquisto del servizio completato con successo");
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
				}
				
			}
		});
		btnAcquista.setForeground(Color.WHITE);
		btnAcquista.setFont(new Font("Arial", Font.BOLD, 20));
		btnAcquista.setBackground(new Color(39, 174, 96));
		btnAcquista.setBounds(483, 331, 229, 67);
		frame.getContentPane().add(btnAcquista);
	}
}
