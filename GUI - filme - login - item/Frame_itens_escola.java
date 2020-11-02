package ling1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Frame_itens_escola extends JFrame {

	private JPanel Panel_main;
	private JTextField Titem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_itens_escola frame = new Frame_itens_escola();
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
	public Frame_itens_escola() {
		HashSet<String> coisas = new HashSet<String>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 450, 350);		
		Panel_main = new JPanel();
		Panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_main);
		Panel_main.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(Panel_main.getLayout());
		
		JPanel Panel0 = new JPanel();
		Panel_main.add(Panel0, "name_1314072375661000");
		Panel0.setLayout(null);
		
		JLabel Ltitle = new JLabel("Itens na Escola");
		Ltitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Ltitle.setHorizontalAlignment(SwingConstants.CENTER);
		Ltitle.setBounds(-10, 10, 450, 25);
		Panel0.add(Ltitle);
		
		JLabel Laviso = new JLabel("");
		Laviso.setHorizontalAlignment(SwingConstants.CENTER);
		Laviso.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Laviso.setBounds(-10, 225, 450, 54);
		Panel0.add(Laviso);
		
		Titem = new JTextField();
		Titem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Laviso.setText("");
			}
		});
		Titem.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Titem.setBounds(65, 75, 300, 30);
		Panel0.add(Titem);
		Titem.setColumns(10);
		
		
		
		JButton Badd = new JButton("Adicionar");
		Badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Titem.getText().equals("")) {
					Laviso.setText("");
				}
				else if (coisas.contains(Titem.getText())) {
					Laviso.setForeground(Color.RED);
					Laviso.setText("Esse item já tem");
				}
				else {
					Item coisa = new Item(Titem.getText());
					coisas.add(coisa.getNome());
					Laviso.setForeground(Color.BLACK);
					Laviso.setText(Titem.getText() + " adicionado");
					Titem.setText("");
				}
			}
		});
		Badd.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Badd.setBounds(35, 145, 90, 42);
		Panel0.add(Badd);
		
		JButton Bver = new JButton("Verificar");
		Bver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (coisas.contains(Titem.getText())) {
					Laviso.setForeground(Color.BLACK);
					Laviso.setText("Esse item está na lista");
				}
				else if (Titem.getText().equals("")) {
				}
				else {
					Laviso.setForeground(Color.BLACK);
					Laviso.setText("Esse item ainda não está lista");
				}
			}
		});
		Bver.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Bver.setBounds(170, 145, 90, 42);
		Panel0.add(Bver);
		
		JButton Btirar = new JButton("Tirar");
		Btirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coisas.contains(Titem.getText())) {
					coisas.remove(Titem.getText());
					Laviso.setForeground(Color.BLACK);
					Laviso.setText(Titem.getText() + " removido da lista");
					Titem.setText("");
				}
			}
		});
		Btirar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Btirar.setBounds(300, 145, 90, 42);
		Panel0.add(Btirar);
		
		
		//evento que corre quando o frame muda de tamanho
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				//pega as dimensões do frame pra serem usadas no redimensionamento dos itens
				Rectangle size = getBounds();
				int x = size.width;
				int y = size.height;
				Ltitle.setBounds(-10, y/25, x, y/15 + x/30);
				Ltitle.setFont(new Font("Times New Roman", Font.BOLD, x/30 + y/30));
				Titem.setBounds(x/7, y/4, x/3 + x/3, y/20 + x/50);
				Titem.setFont(new Font("Times New Roman", Font.PLAIN, x/40 + y/40));
				Badd.setBounds(x/12, y/2 - y/12, x/5, y/8);
				Badd.setFont(new Font("Times New Roman", Font.BOLD, x/60 + y/60));
				Bver.setBounds(x/3 + x/24, y/2 - y/12, x/5, y/8);
				Bver.setFont(new Font("Times New Roman", Font.BOLD, x/60 + y/60));
				Btirar.setBounds(x/2 + x/6, y/2 - y/12, x/5, y/8);
				Btirar.setFont(new Font("Times New Roman", Font.BOLD, x/60 + y/60));
				Laviso.setBounds(-10, y/2 + y/7, x - x/20, 65);
				Laviso.setFont(new Font("Times New Roman", Font.PLAIN, x/35 + y/35));
			}
		});
	}
}
