package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RitornoHome {

	JFrame frame;
	private JTextArea BoxInfo;
	private int pagina;
	private JLabel lblNewLabel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RitornoHome window = new RitornoHome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void setMessage (String m) {
		this.lblNewLabel_1.setText(m);
	}
	
	public String getMessage () {
		return this.lblNewLabel_1.getText();
	}
	
	public void setPagina (int p) {
		pagina = p;
	}
	
	public int getPagina () {
		return pagina;
	}
	
	
	/**
	 * Create the application.
	 */
	public RitornoHome() {
		initialize();
		pagina = 0;
		//BoxInfo.setText("no info disponibili");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(44, 62, 80));
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
		
		JButton btnChiudi = new JButton("TORNA ALLA HOME\r\n\r\n");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(pagina == 1) {

					try {
						HomeClienteRegistrato window = new HomeClienteRegistrato();
						window.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (NumberFormatException e1) {
						System.out.println(e1.getMessage());
					}
				}else if(pagina == 2) {
					try {
						HomeOperatore window = new HomeOperatore();
						window.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (NumberFormatException e1) {
						System.out.println(e1.getMessage());
					}
				}else if (pagina == 3) {
					try {
						HomeOspite window = new HomeOspite();
						window.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (NumberFormatException e1) {
						System.out.println(e1.getMessage());
					}
				}else if (pagina == 4) {
					try {
						HomeGestore window = new HomeGestore();
						window.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (NumberFormatException e1) {
						System.out.println(e1.getMessage());
					}
				}
			}
		});
		btnChiudi.setForeground(new Color(255, 255, 255));
		btnChiudi.setFont(new Font("Arial", Font.BOLD, 16));
		btnChiudi.setBackground(new Color(39, 174, 96));
		btnChiudi.setBounds(274, 386, 207, 55);
		frame.getContentPane().add(btnChiudi);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(89, 193, 575, 94);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
