package boundary;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import database.SettoreDAO;
import entity.Settore;
import exception.DAOException;
import exception.DBConnectionException;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EffettuaPrenotazione {

	private JFrame frmDue;
	private JTextField txtMariorussogmailcom;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDue = new JFrame();
		frmDue.setResizable(false);
		frmDue.getContentPane().setBackground(new Color(44, 62, 80));
		frmDue.getContentPane().setLayout(null);
		
		/*JLabel lblNewLabel = new JLabel("");
		ImageIcon icon = new ImageIcon("C:\\Users\\domenico\\OneDrive\\Desktop\\JavaDUE\\Progetto-DUE\\PROGETTO-IS\\DUE\\resources\\camp2.jpg");
		lblNewLabel.setBounds(-31, -57, 807, 347);
		lblNewLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance(lblNewLabel.getBounds().width, lblNewLabel.getBounds().height,  java.awt.Image.SCALE_SMOOTH)));
		frmDue.getContentPane().add(lblNewLabel);*/
		
		JButton btnNewButton = new JButton("EFFETTUA PRENOTAZIONE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//NomeFinestra2 f = new NomeFinestra2();
				//f.show();
			}
		});
		btnNewButton.setBackground(new Color(39, 174, 96));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(195, 405, 381, 44);
		frmDue.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(195, 269, 381, 44);
		try {
			for(Settore s : SettoreDAO.getSettori()) {
				comboBox.addItem(s.getTipoSettore() + " - " + s.getCosto() + " €");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (DBConnectionException e) {
			e.printStackTrace();
		}
		frmDue.getContentPane().add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(195, 140, 153, 19);
		frmDue.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(423, 140, 153, 19);
		frmDue.getContentPane().add(dateChooser_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 174, 96));
		panel.setBounds(0, 0, 775, 74);
		frmDue.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(683, 20, 68, 39);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(new Color(44, 62, 80));
		btnNewButton_1.setBackground(new Color(39, 174, 96));
		btnNewButton_1.setBounds(10, 20, 102, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Data Inizio ");
		lblNewLabel_1.setForeground(new Color(39, 174, 96));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(194, 90, 109, 40);
		frmDue.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data Fine ");
		lblNewLabel_2.setForeground(new Color(39, 174, 96));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(422, 90, 96, 40);
		frmDue.getContentPane().add(lblNewLabel_2);
		
		txtMariorussogmailcom = new JTextField();
		txtMariorussogmailcom.setText("\r\n");
		txtMariorussogmailcom.setBounds(195, 209, 381, 32);
		frmDue.getContentPane().add(txtMariorussogmailcom);
		txtMariorussogmailcom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("email");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(39, 174, 96));
		lblNewLabel_3.setBounds(195, 169, 124, 30);
		frmDue.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(195, 339, 381, 44);
		frmDue.getContentPane().add(comboBox_1);
		frmDue.setTitle("DUE");
		frmDue.setBounds(100, 100, 788, 527);
		frmDue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
