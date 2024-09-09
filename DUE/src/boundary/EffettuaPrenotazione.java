package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import control.GestioneCampeggio;
import database.SettoreDAO;
import entity.Prenotazione;
import exception.DAOException;
import exception.DBConnectionException;
import javax.swing.ImageIcon;

public class EffettuaPrenotazione {

	JFrame frmDue;
	private JTextField txtFieldEmail;
	ArrayList<String> results = null;
	private LocalDate localdatai;
	private LocalDate localdataf;
	private int codiceSettore;
	private Prenotazione p;
	private JDateChooser dataInizio;
	private JDateChooser dataFine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EffettuaPrenotazione window = new EffettuaPrenotazione();
					window.frmDue.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EffettuaPrenotazione() {
		initialize();
		localdatai=null;
		localdataf=null;
		codiceSettore = 0;
		p = null;
		results = new ArrayList();
		
		txtFieldEmail.setText("mario.rossi@gmail.com");
		
		dataInizio = new JDateChooser();
		dataInizio.setForeground(new Color(44, 62, 80));
		dataInizio.setDate(new Date());
		dataInizio.setBounds(195, 127, 161, 32);
		frmDue.getContentPane().add(dataInizio);
		
		dataFine = new JDateChooser();
		dataFine.setDate(new Date());
		dataFine.setBounds(406, 127, 161, 32);
		frmDue.getContentPane().add(dataFine);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		GestioneCampeggio gestioneCampeggio = GestioneCampeggio.getInstance();
		
		frmDue = new JFrame();
		frmDue.setResizable(false);
		
		frmDue.getContentPane().setBackground(new Color(44, 62, 80));
		frmDue.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		/*comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				results.add(String.valueOf(comboBox.getSelectedItem())); //elemento 2
				
			}
		});*/
		comboBox.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox.setBounds(195, 269, 381, 44);
		/*try {
			for(Settore s : SettoreDAO.getSettori()) {
				comboBox.addItem(s.getCategoria());
			}
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		} catch (DBConnectionException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		}*/
		frmDue.getContentPane().add(comboBox);
		comboBox.addItem("ECONOMY");
		comboBox.addItem("PREMIUM");
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 174, 96));
		panel.setBounds(0, 0, 775, 74);
		frmDue.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomeClienteRegistrato window = new HomeClienteRegistrato();
					window.frame.setVisible(true);
					frmDue.setVisible(false);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
				}
				
			}
		});
		
		JLabel LOGO = new JLabel("");
		LOGO.setBounds(692, 7, 60, 60);
		ImageIcon i = new ImageIcon(EffettuaPrenotazione.class.getResource("/images/logo.png"));
		Image ok = i.getImage().getScaledInstance(LOGO.getWidth(), LOGO.getHeight(), Image.SCALE_SMOOTH);
		LOGO.setIcon(new ImageIcon(ok));
		LOGO.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(LOGO);
		
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1.setBounds(10, 20, 102, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Data Inizio ");
		lblNewLabel_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(222, 90, 109, 40);
		frmDue.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data Fine ");
		lblNewLabel_2.setForeground(new Color(39, 174, 96));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(441, 90, 96, 40);
		frmDue.getContentPane().add(lblNewLabel_2);
		
		txtFieldEmail = new JTextField();
		/*txtFieldEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				results.add(txtFieldEmail.getText()); //elemento 3
			}
		});*/
		txtFieldEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		txtFieldEmail.setBounds(195, 209, 381, 32);
		frmDue.getContentPane().add(txtFieldEmail);
		txtFieldEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("email");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(39, 174, 96));
		lblNewLabel_3.setBounds(195, 169, 124, 30);
		frmDue.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.BOLD, 16));
		/*comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				results.add(String.valueOf(comboBox_1.getSelectedItem())); //elemento 4
			}
		});*/
		comboBox_1.setBounds(195, 339, 381, 44);
		
		/*try {
			for(Settore s : SettoreDAO.getSettori()) {
				comboBox_1.addItem(s.getTipoSettore());
			}
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		} catch (DBConnectionException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		}*/
		comboBox_1.addItem("CAMPER");
		comboBox_1.addItem("TENDA");
		
		frmDue.getContentPane().add(comboBox_1);
		
		
		JButton btnNewButton = new JButton("EFFETTUA PRENOTAZIONE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate localdatai = dataInizio.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate localdataf = dataFine.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				try {
					codiceSettore = SettoreDAO.getCodiceSettoreDAO(
							comboBox.getSelectedItem().toString(),
							comboBox_1.getSelectedItem().toString()
					);
				}
						catch (DAOException e2) {
							JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e2.getMessage());
				} catch (DBConnectionException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
				}
				
				try {
					if(!localdatai.plusDays(1).isAfter(LocalDate.now())) {
						JOptionPane.showMessageDialog(null, "Non puoi prenotare nel passato :(");
						return;
					}
					
					if(dataInizio.getDate() == null || dataFine.getDate() == null || txtFieldEmail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Devi compilare tutti i campi!");
						return;
					}
					
					if(localdatai.isAfter(localdataf)) {
						JOptionPane.showMessageDialog(null, "La data di inizio deve venire prima della data di fine!");
						return;
					}
					
					if(localdataf.compareTo(localdatai) != 7 || (localdataf.getDayOfWeek().toString() != "SATURDAY" && localdataf.getDayOfWeek().toString() != "SATURDAY")) {
						JOptionPane.showMessageDialog(null, "La data di inizio e di fine devono essere due sabati ad una settimana di distanza");
						return;
					}
					
					p = gestioneCampeggio.EffettuaPrenotazione(
							localdatai, 
							localdataf, 
							codiceSettore, 
							comboBox.getSelectedItem().toString(), 
							comboBox.getSelectedItem().toString(), 
							txtFieldEmail.getText()
					);
					
					EffettuaPrenotazione_2 window = new EffettuaPrenotazione_2(p);
					window.frame.setVisible(true);
					frmDue.setVisible(false);
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
					// TODO Auto-generated catch block
					if (e1.getMessage().equals("Piazzola non disponibile")) {
						try {
							RitornoHome window = new RitornoHome();
							window.setPagina(1);
							window.setMessage(e1.getMessage());
							window.frame.setVisible(true);
							frmDue.setVisible(false);
							
						} catch (NumberFormatException e3) {
							JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
						}
						
					}else System.out.println(e1.getMessage());
				}
				
				
						
				
			}
		});
		btnNewButton.setBackground(new Color(39, 174, 96));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(195, 405, 381, 44);
		frmDue.getContentPane().add(btnNewButton);
		
		
		
		
		frmDue.setTitle("DUE");
		frmDue.setBounds(100, 100, 788, 527);
		frmDue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
