package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import database.PiazzolaDAO;
import database.PrenotazioneDAO;
import database.SettoreDAO;
import entity.Prenotazione;
import entity.Settore;
import exception.DAOException;
import exception.DBConnectionException;

public class EffettuaPrenotazione_2 {

	JFrame frame;
	private JTextField dataFineText;
	private JTextField dataInizioText;
	private JTextField piazzolaText;
	private JTextField costoText;
	private JTextField clienteText;
	ArrayList<String> result = null;
	private static Prenotazione p;
	private Settore s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EffettuaPrenotazione_2 window = new EffettuaPrenotazione_2(p);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param p 
	 */
	public EffettuaPrenotazione_2(Prenotazione p) {
		this.p = p;
		try {
			this.s = SettoreDAO.readSettore(
				PiazzolaDAO.readPiazzola(this.p.getPiazzola()).getCodiceSettore()
			);
		} catch (DAOException | DBConnectionException e) {
			JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e.getMessage());
		}
				
		initialize();
		/*dataFineText.setText("2024-09-10");
		dataInizioText.setText("2024-09-01");
		piazzolaText.setText("01");
		costoText.setText("");
		clienteText.setText("mario.rossi@gmail.com");*/
		result = null;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
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
					EffettuaPrenotazione window = new EffettuaPrenotazione();
					window.frmDue.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
				}
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(
					dataInizioText.getText().isEmpty() ||
					dataFineText.getText().isEmpty() ||
					costoText.getText().isEmpty() || 
					piazzolaText.getText().isEmpty() ||
					clienteText.getText().isEmpty()
				) {
					JOptionPane.showMessageDialog(null, "Devi compilare tutti i campi!");
				}
					
				RitornoHome window = new RitornoHome();
				window.setPagina(1);
				
				try {
					PrenotazioneDAO.createPrenotazione(p);
					window.setMessage("Prenotazione effettuata con successo");
				} catch (DAOException e1) {
					window.setMessage("Non è stato possibile inserire la prenotazione: " + e1.getMessage());
					e1.printStackTrace();
				} catch (DBConnectionException e1) {
					window.setMessage("Non è stato possibile inserire la prenotazione: " + e1.getMessage());
					e1.printStackTrace();
				}
				
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(39, 174, 96));
		btnNewButton.setBounds(431, 365, 133, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAnnulla = new JButton("ANNULLA");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					RitornoHome window = new RitornoHome();
					window.setPagina(1);
					window.setMessage("Operazione annullata con successo");
					window.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Si è verificato un errore: " + e1.getMessage());
				}
				
			}
		});
		btnAnnulla.setForeground(Color.WHITE);
		btnAnnulla.setFont(new Font("Arial", Font.BOLD, 16));
		btnAnnulla.setBackground(new Color(39, 174, 96));
		btnAnnulla.setBounds(243, 365, 133, 44);
		frame.getContentPane().add(btnAnnulla);
		
		dataFineText = new JTextField();
		dataFineText.setEditable(false);
		dataFineText.setText(p.getDataFine().toString());
		dataFineText.setFont(new Font("Arial", Font.BOLD, 16));
		dataFineText.setColumns(10);
		dataFineText.setBounds(527, 126, 170, 32);
		frame.getContentPane().add(dataFineText);
		
		dataInizioText = new JTextField();
		dataInizioText.setEditable(false);
		dataInizioText.setText(p.getDataInizio().toString());
		dataInizioText.setFont(new Font("Arial", Font.BOLD, 16));
		dataInizioText.setColumns(10);
		dataInizioText.setBounds(214, 127, 170, 32);
		frame.getContentPane().add(dataInizioText);
		
		piazzolaText = new JTextField();
		piazzolaText.setEditable(false);
		piazzolaText.setText(p.getPiazzola()+"");
		piazzolaText.setFont(new Font("Arial", Font.BOLD, 16));
		piazzolaText.setColumns(10);
		piazzolaText.setBounds(267, 191, 170, 32);
		frame.getContentPane().add(piazzolaText);
		
		costoText = new JTextField();
		costoText.setEditable(false);
		costoText.setText(s.getCosto()+" €");
		costoText.setFont(new Font("Arial", Font.BOLD, 16));
		costoText.setColumns(10);
		costoText.setBounds(517, 233, 146, 32);
		frame.getContentPane().add(costoText);
		
		clienteText = new JTextField();
		clienteText.setEditable(false);
		clienteText.setText(p.getClienteRegistrato());
		clienteText.setFont(new Font("Arial", Font.BOLD, 16));
		clienteText.setColumns(10);
		clienteText.setBounds(186, 261, 295, 32);
		frame.getContentPane().add(clienteText);
	}
}
