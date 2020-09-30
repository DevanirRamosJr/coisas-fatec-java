package ling1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Frame_planet extends JFrame {

	private JPanel Panel00;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_planet frame = new Frame_planet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_planet() {
		//já cria os planetas quando o programa inicia
		Planet[] planeta = new Planet[8];
		planeta[0] = new Planet("Mercúrio", "marrom acinzentada.", "88 dias terrestres.", "55 dias terrestres.", 2440, 5.8f, -173, 427, 169);
		planeta[1] = new Planet("Vênus", "alaranjada.", "225 dias terrestres", "117 dias terrestres", 6052, 10.8f, 462);
		planeta[2] = new Planet("Terra", "azul e verde.", "365 dias.", "24 horas.", 6371, 15f, 15);
		planeta[3] = new Planet("Marte", "vermelha.", "687 dias terrestres.", "1 dia terrestre", 3389, 23f, -63);
		planeta[4] = new Planet("Júpiter", "marrom e branca.", "12 anos terrestres.", "10h terrestres.", 69911, 78f, -110);
		planeta[5] = new Planet("Saturno", "marrom.", "29 anos terrestres.", "11 horas terrestres.", 58232, 143f, -139);
		planeta[6] = new Planet("Urano", "azul claro.", "84 anos terrestres.", "17 horas terrestres.", 25362, 287f, -220);
		planeta[7] = new Planet("Netuno", "azul escuro.", "165 anos terrestres.", "16 horas terrestres.", 24622, 450f, -223);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 487, 458);
		Panel00 = new JPanel();
		Panel00.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel00);
		Panel00.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(Panel00.getLayout());
		
		JPanel Pinit = new JPanel();
		Panel00.add(Pinit, "name_623485950380000");
		Pinit.setLayout(null);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(Panel00, "0");
			}
		});
		btnNewButton.setBounds(140, 201, 181, 52);
		Pinit.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Dados dos Planetas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 15, 442, 52);
		Pinit.add(lblNewLabel_1);

		
		
		JPanel Pplanet = new JPanel();
		Panel00.add(Pplanet, "1");
		Pplanet.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("Voltar");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(Panel00, "0");
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_8.setBounds(166, 359, 126, 39);
		Pplanet.add(btnNewButton_8);
		
		JLabel Lnome = new JLabel("Merc\u00FArio");
		Lnome.setHorizontalAlignment(SwingConstants.CENTER);
		Lnome.setFont(new Font("Times New Roman", Font.BOLD, 26));
		Lnome.setBounds(10, 15, 441, 48);
		Pplanet.add(Lnome);
		
		JLabel Lano = new JLabel("A duração do ano é de 0 dias terrestres.");
		Lano.setHorizontalAlignment(SwingConstants.CENTER);
		Lano.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lano.setBounds(10, 84, 441, 39);
		Pplanet.add(Lano);
		
		JLabel Ldia = new JLabel("A duração do dia é de 0 dias terrestres.");
		Ldia.setHorizontalAlignment(SwingConstants.CENTER);
		Ldia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Ldia.setBounds(10, 134, 441, 33);
		Pplanet.add(Ldia);
		
		JLabel Lcor = new JLabel("Sua cor é .");
		Lcor.setHorizontalAlignment(SwingConstants.CENTER);
		Lcor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lcor.setBounds(10, 178, 441, 33);
		Pplanet.add(Lcor);
		
		JLabel Lraio = new JLabel("Seu raio é de km.");
		Lraio.setHorizontalAlignment(SwingConstants.CENTER);
		Lraio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lraio.setBounds(10, 222, 441, 33);
		Pplanet.add(Lraio);
		
		JLabel Ldist = new JLabel("Sua distância do sol é de *10 milhões de km.");
		Ldist.setHorizontalAlignment(SwingConstants.CENTER);
		Ldist.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Ldist.setBounds(10, 266, 441, 33);
		Pplanet.add(Ldist);
		
		JLabel Ltemp = new JLabel("Sua temperatura média é de ºC");
		Ltemp.setHorizontalAlignment(SwingConstants.CENTER);
		Ltemp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Ltemp.setBounds(10, 310, 441, 33);
		Pplanet.add(Ltemp);
		
		
		
		JPanel Pselect = new JPanel();
		Panel00.add(Pselect, "0");
		Pselect.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha um Planeta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 15, 441, 48);
		Pselect.add(lblNewLabel);
		
		String[] planetas = {"Selecione", "Mercúrio", "Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno"};
		JComboBox comboBox = new JComboBox(planetas);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		comboBox.setBounds(165, 114, 128, 34);
		Pselect.add(comboBox);
		
		JButton btnNewButton_7 = new JButton("Ver Dados");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
				}
				else {
					cl.show(Panel00, "1");
					int i = comboBox.getSelectedIndex();
					Lnome.setText(planeta[i - 1].getNome());
					Lano.setText("A duração do ano é de " + planeta[i - 1].getAno());
					Ldia.setText("A duração do dia é de " + planeta[i - 1].getDia());
					Lcor.setText("A sua cor é  " + planeta[i - 1].getCor());
					Lraio.setText("Seu raio é de "+ planeta[i - 1].getRaio() + "km.");
					Ldist.setText("Sua distância do sol é de " + planeta[i - 1].getDistancia() + "*10 milhões de km.");
					Ltemp.setText("Sua temperatura média é de " + planeta[i - 1].getTemp_med() + "ºC.");
				}
				
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_7.setBounds(163, 301, 136, 40);
		Pselect.add(btnNewButton_7);
		
		
		
		
	}
}
