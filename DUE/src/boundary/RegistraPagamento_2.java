package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.GestioneCampeggio;
import database.AcquistoDAO;
import database.ContiSpeseDAO;
import entity.ContoSpese;
import entity.Servizio;
import exception.DAOException;
import exception.DBConnectionException;
import exception.OperationException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistraPagamento_2 {

	JFrame frame;
	private JTextField textField;
	private static ContoSpese c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistraPagamento_2 window = new RegistraPagamento_2(c);
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
	public RegistraPagamento_2(ContoSpese c) {
		this.c = c;
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
		LOGO.setBounds(692, 7, 60, 60);
		ImageIcon i = new ImageIcon(EffettuaPrenotazione.class.getResource("/images/logo.png"));
		Image ok = i.getImage().getScaledInstance(LOGO.getWidth(), LOGO.getHeight(), Image.SCALE_SMOOTH);
		LOGO.setIcon(new ImageIcon(ok));
		LOGO.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(LOGO);
		
		
		JButton btnChiudiConto = new JButton("CHIUDI CONTO");
		btnChiudiConto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestioneCampeggio.getInstance().RegistrazionePagamento(c.getCodiceConto());
					
					RitornoHome window3 = new RitornoHome();
					window3.setPagina(1);
					window3.setMessage("Il conto N°" + c.getCodiceConto() + " è stato chiuso con successo");
					window3.frame.setVisible(true);
					frame.setVisible(false);
				} catch (OperationException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
				}
				
			}
		});
		btnChiudiConto.setForeground(Color.WHITE);
		btnChiudiConto.setFont(new Font("Arial", Font.BOLD, 16));
		btnChiudiConto.setBackground(new Color(39, 174, 96));
		btnChiudiConto.setBounds(413, 397, 182, 44);
		frame.getContentPane().add(btnChiudiConto);
		
		JButton btnAnnulla = new JButton("ANNULLA");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrazionePagamento window = new RegistrazionePagamento();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAnnulla.setForeground(Color.WHITE);
		btnAnnulla.setFont(new Font("Arial", Font.BOLD, 16));
		btnAnnulla.setBackground(new Color(39, 174, 96));
		btnAnnulla.setBounds(149, 397, 182, 44);
		frame.getContentPane().add(btnAnnulla);
		
		ArrayList<String> spese = new ArrayList<String>();
		
		try {
			for(Servizio s : AcquistoDAO.getListaServizi(c.getCodiceConto())) {
				spese.add(s.getTipoServizio() + " - " + s.getPrezzoServizio() + " €");
			}
			
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		} catch (DBConnectionException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		}
		
		JList list = new JList(spese.toArray());
		list.setFont(new Font("Arial", Font.BOLD, 16));
		list.setBounds(130, 94, 490, 223);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel_1_1_2_1_2_1 = new JLabel("Totale corrente\r\n");
		lblNewLabel_1_1_2_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_1_2_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1_1_2_1_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1_2_1_2_1.setBounds(135, 327, 164, 44);
		frame.getContentPane().add(lblNewLabel_1_1_2_1_2_1);
		
		float totale = 0;
		
		try {
			totale = ContiSpeseDAO.getTotaleCorrente(c.getCodiceConto());
		} catch (DAOException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		} catch (DBConnectionException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		}
		
		textField = new JTextField();
		textField.setText(totale + " €");
		textField.setFont(new Font("Arial", Font.BOLD, 16));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(318, 335, 133, 32);
		frame.getContentPane().add(textField);
		frame.setBounds(100, 100, 788, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
