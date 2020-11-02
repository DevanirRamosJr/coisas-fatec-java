package ling1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame_filme extends JFrame {

	private JPanel Panel_main;
	private JTextField Tnome;
	private JTextField Tdata;
	

	private JLabel Lnome0;
	private JLabel Ltipo0;
	private JLabel Ldata0;
	private JLabel Llocal0;
	private JLabel Ltitle0;
	
	
	private int click;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_filme frame = new Frame_filme();
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
	public Frame_filme() {
		ArrayList<Filme> lista = new ArrayList<Filme>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 450, 500);
		setResizable(false);
		Panel_main = new JPanel();
		Panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_main);
		Panel_main.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(Panel_main.getLayout());
		
		
		
		JPanel panel = new JPanel();
		Panel_main.add(panel, "0");
		panel.setLayout(null);
		
		
		JPanel panel_ver = new JPanel();
		Panel_main.add(panel_ver,"1");
		panel_ver.setLayout(null);
		
		
		
		JLabel Ltitle;
		Ltitle0 = new JLabel("Lista de Filmes/S\u00E9ries");
		Ltitle0.setHorizontalAlignment(SwingConstants.CENTER);
		Ltitle0.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Ltitle0.setBounds(0, 10, 434, 36);
		panel.add(Ltitle0);
		
		JLabel Lnome;
		Lnome0 = new JLabel("T\u00EDtulo:");
		Lnome0.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lnome0.setBounds(10, 77, 140, 24);
		panel.add(Lnome0);
		
		Tnome = new JTextField();
		Tnome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Tnome.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Tnome.setBackground(Color.WHITE);
			}
		});
		Tnome.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Tnome.setBounds(10, 112, 405, 30);
		panel.add(Tnome);
		Tnome.setColumns(10);
		
		JLabel Ltipo;
		Ltipo0 = new JLabel("Tipo:");
		Ltipo0.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ltipo0.setBounds(10, 153, 140, 24);
		panel.add(Ltipo0);
		
		String[] tipos = {"Selecione", "Filme", "Série", "Documentário", "Anime", "Dorama", "Desenho", "Show"};
		JComboBox CBtipo = new JComboBox(tipos);
		CBtipo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		CBtipo.setBounds(10, 188, 145, 30);
		panel.add(CBtipo);
		CBtipo.setSelectedIndex(0);
		
		JLabel Ldata;
		Ldata0 = new JLabel("Data:");
		Ldata0.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ldata0.setBounds(10, 229, 140, 24);
		panel.add(Ldata0);
		
		Tdata = new JTextField();
		Tdata.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Tdata.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Tdata.setBackground(Color.WHITE);
			}
		});
		Tdata.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Tdata.setColumns(10);
		Tdata.setBounds(10, 261, 110, 30);
		panel.add(Tdata);
		
		JLabel Llocal;
		Llocal0 = new JLabel("Onde:");
		Llocal0.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Llocal0.setBounds(10, 302, 140, 24);
		panel.add(Llocal0);
		
		String[] locais = {"Selecione", "Netflix", "Prime Video", "Disney+", "Hulu", "Globo Play", "Outro"};
		JComboBox CBlocal = new JComboBox(locais);
		CBlocal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		CBlocal.setBounds(10, 337, 145, 30);
		panel.add(CBlocal);
		
		
		
		
		JButton Badd = new JButton("Adicionar");
		Badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//adiciona o objeto na lista
	    		lista.add(new Filme  (Tnome.getText(), Tdata.getText(), locais[CBlocal.getSelectedIndex()], tipos[CBtipo.getSelectedIndex()]));				
	    		Tnome.setText("");
				Tdata.setText("");
	    		CBtipo.setSelectedIndex(0);
	    		CBlocal.setSelectedIndex(0);
	    		Tnome.requestFocus();
			}
		});
		Badd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Badd.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Badd.setBackground(null);
			}
		});
		Badd.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
		        	//adiciona o objeto na lista
		    		lista.add(new Filme  (Tnome.getText(), Tdata.getText(), locais[CBlocal.getSelectedIndex()], tipos[CBtipo.getSelectedIndex()]));				
		    		Tnome.setText("");
					Tdata.setText("");
		    		CBtipo.setSelectedIndex(0);
		    		CBlocal.setSelectedIndex(0);
		    		Tnome.requestFocus();
		        }
			}
		});
		Badd.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Badd.setBounds(50, 388, 132, 47);
		panel.add(Badd);
		
		
		
		
		JButton Bvoltar = new JButton("Voltar");
		Bvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(Panel_main, "0");
				Tnome.requestFocus();
				click = 0;
			}
		});
		Bvoltar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Bvoltar.setBackground(Color.LIGHT_GRAY);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				Bvoltar.setBackground(null);
			}
		});
		Bvoltar.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
		        	cl.show(Panel_main, "0");
		        	Tnome.requestFocus();
		        	click = 0;
		        }
			}
		});
		Bvoltar.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Bvoltar.setBounds(50, 388, 132, 47);
		panel_ver.add(Bvoltar);
		

		
		
		
		
		//maioria do conteudo do panel_ver
		JLabel Ltitle1 = new JLabel("Lista de Filmes/S\u00E9ries");
		Ltitle1.setHorizontalAlignment(SwingConstants.CENTER);
		Ltitle1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Ltitle1.setBounds(0, 10, 434, 36);
		panel_ver.add(Ltitle1);
		
		JLabel Lnome1 = new JLabel("T\u00EDtulo:");
		Lnome1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lnome1.setBounds(10, 77, 405, 30);
		panel_ver.add(Lnome1);
		
		JLabel Ldata1 = new JLabel("data");
		Ldata1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ldata1.setBounds(165, 112, 102, 30);
		panel_ver.add(Ldata1);
		
		JLabel Ltipo1 = new JLabel("tipo");
		Ltipo1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ltipo1.setBounds(10, 112, 132, 30);
		panel_ver.add(Ltipo1);
		
		JLabel Llocal1 = new JLabel("prime video");
		Llocal1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Llocal1.setBounds(299, 112, 116, 30);
		panel_ver.add(Llocal1);
		
		JLabel Lnome_1 = new JLabel("T\u00EDtulo:");
		Lnome_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lnome_1.setBounds(10, 177, 405, 30);
		panel_ver.add(Lnome_1);
		
		JLabel Ltipo_1 = new JLabel("tipo");
		Ltipo_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ltipo_1.setBounds(10, 212, 102, 30);
		panel_ver.add(Ltipo_1);
		
		JLabel Ldata_1 = new JLabel("tipo");
		Ldata_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ldata_1.setBounds(146, 212, 102, 30);
		panel_ver.add(Ldata_1);
		
		JLabel Llocal_1 = new JLabel("prime video");
		Llocal_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Llocal_1.setBounds(299, 212, 116, 30);
		panel_ver.add(Llocal_1);
		
		JLabel Lnome_2 = new JLabel("T\u00EDtulo:");
		Lnome_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lnome_2.setBounds(10, 284, 405, 30);
		panel_ver.add(Lnome_2);
		
		JLabel Ltipo_2 = new JLabel("tipo");
		Ltipo_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ltipo_2.setBounds(10, 319, 102, 30);
		panel_ver.add(Ltipo_2);
		
		JLabel Ldata_2 = new JLabel("tipo");
		Ldata_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ldata_2.setBounds(146, 319, 102, 30);
		panel_ver.add(Ldata_2);
		
		JLabel Llocal_2 = new JLabel("prime video");
		Llocal_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Llocal_2.setBounds(299, 319, 116, 30);
		panel_ver.add(Llocal_2);
		
		click = 0;
		JButton Bmais = new JButton("Mais");
		Bmais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	click += 1;
	        	//se o tamanho da lista for menor q múltiplo de 3 então n precisa "mostrar uma nova página"
	        	//então o click volta pra 0 e mostra os primeiros 3 objetos
	        	if (lista.size() < (click * 3) + 1) {
	        		click = 0;
					Lnome1.setText(lista.get(click).getNome());
					Ldata1.setText(lista.get(click).getData());
					Llocal1.setText(lista.get(click).getLocal());
					Ltipo1.setText(lista.get(click).getTipo());
					
					Lnome_1.setText(lista.get(click * 3 + 1).getNome());
					Ldata_1.setText(lista.get(click * 3 + 1).getData());
					Llocal_1.setText(lista.get(click * 3 + 1).getLocal());
					Ltipo_1.setText(lista.get(click * 3 + 1).getTipo());
					
					Lnome_2.setText(lista.get(click * 3 + 2).getNome());
					Ldata_2.setText(lista.get(click * 3 + 2).getData());
					Llocal_2.setText(lista.get(click * 3 + 2).getLocal());
					Ltipo_2.setText(lista.get(click * 3 + 2).getTipo());
					
	        	}
	        	else {		
	        		Lnome_1.setText("");
	        		Ldata_1.setText("");
	        		Llocal_1.setText("");
	        		Ltipo_1.setText("");
	        		
	        		Lnome_2.setText("");
	        		Ldata_2.setText("");
	        		Llocal_2.setText("");
	        		Ltipo_2.setText("");
		        		
		        	Lnome1.setText(lista.get(click * 3).getNome());
					Ldata1.setText(lista.get(click * 3).getData());
					Llocal1.setText(lista.get(click * 3).getLocal());
					Ltipo1.setText(lista.get(click * 3).getTipo());
					
					Lnome_1.setText(lista.get(click * 3 + 1).getNome());
					Ldata_1.setText(lista.get(click * 3 + 1).getData());
					Llocal_1.setText(lista.get(click * 3 + 1).getLocal());
					Ltipo_1.setText(lista.get(click * 3 + 1).getTipo());
					
					Lnome_2.setText(lista.get(click * 3 + 2).getNome());
					Ldata_2.setText(lista.get(click * 3 + 2).getData());
					Llocal_2.setText(lista.get(click * 3 + 2).getLocal());
					Ltipo_2.setText(lista.get(click * 3 + 2).getTipo());
	        	}
			}
		});
		Bmais.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Bmais.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Bmais.setBackground(null);
			}
		});
		Bmais.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
		        	click += 1;
		        	//se o tamanho da lista for menor q múltiplo de 3 então n precisa "mostrar uma nova página"
		        	//então o click volta pra 0 e mostra os primeiros 3 objetos
		        	if (lista.size() < (click * 3) + 1) {
		        		click = 0;
						Lnome1.setText(lista.get(click).getNome());
						Ldata1.setText(lista.get(click).getData());
						Llocal1.setText(lista.get(click).getLocal());
						Ltipo1.setText(lista.get(click).getTipo());
						
						Lnome_1.setText(lista.get(click * 3 + 1).getNome());
						Ldata_1.setText(lista.get(click * 3 + 1).getData());
						Llocal_1.setText(lista.get(click * 3 + 1).getLocal());
						Ltipo_1.setText(lista.get(click * 3 + 1).getTipo());
						
						Lnome_2.setText(lista.get(click * 3 + 2).getNome());
						Ldata_2.setText(lista.get(click * 3 + 2).getData());
						Llocal_2.setText(lista.get(click * 3 + 2).getLocal());
						Ltipo_2.setText(lista.get(click * 3 + 2).getTipo());
						
		        	}
		        	else {		
		        		Lnome_1.setText("");
		        		Ldata_1.setText("");
		        		Llocal_1.setText("");
		        		Ltipo_1.setText("");
		        		
		        		Lnome_2.setText("");
		        		Ldata_2.setText("");
		        		Llocal_2.setText("");
		        		Ltipo_2.setText("");
			        		
			        	Lnome1.setText(lista.get(click * 3).getNome());
						Ldata1.setText(lista.get(click * 3).getData());
						Llocal1.setText(lista.get(click * 3).getLocal());
						Ltipo1.setText(lista.get(click * 3).getTipo());
						
						Lnome_1.setText(lista.get(click * 3 + 1).getNome());
						Ldata_1.setText(lista.get(click * 3 + 1).getData());
						Llocal_1.setText(lista.get(click * 3 + 1).getLocal());
						Ltipo_1.setText(lista.get(click * 3 + 1).getTipo());
						
						Lnome_2.setText(lista.get(click * 3 + 2).getNome());
						Ldata_2.setText(lista.get(click * 3 + 2).getData());
						Llocal_2.setText(lista.get(click * 3 + 2).getLocal());
						Ltipo_2.setText(lista.get(click * 3 + 2).getTipo());
		        	}
		        }
			}
		});
		Bmais.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Bmais.setBounds(245, 388, 132, 47);
		panel_ver.add(Bmais);
				
		
		
		
		Lnome1.setText("");
		Ldata1.setText("");
		Llocal1.setText("");
		Ltipo1.setText("");
		
		Lnome_1.setText("");
		Ldata_1.setText("");
		Llocal_1.setText("");
		Ltipo_1.setText("");
		
		Lnome_2.setText("");
		Ldata_2.setText("");
		Llocal_2.setText("");
		Ltipo_2.setText("");
		
		JButton Bver = new JButton("Ver Lista");
		Bver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
	    		Tnome.setText("");
				Tdata.setText("");
	    		CBtipo.setSelectedIndex(0);
	    		CBlocal.setSelectedIndex(0);
	    		
				cl.show(Panel_main, "1");
				Bvoltar.requestFocus();
				Lnome1.setText(lista.get(0).getNome());
				Ldata1.setText(lista.get(0).getData());
				Llocal1.setText(lista.get(0).getLocal());
				Ltipo1.setText(lista.get(0).getTipo());
				
				Lnome_1.setText(lista.get(1).getNome());
				Ldata_1.setText(lista.get(1).getData());
				Llocal_1.setText(lista.get(1).getLocal());
				Ltipo_1.setText(lista.get(1).getTipo());
				
				Lnome_2.setText(lista.get(2).getNome());
				Ldata_2.setText(lista.get(2).getData());
				Llocal_2.setText(lista.get(2).getLocal());
				Ltipo_2.setText(lista.get(2).getTipo());
			}
		});
		Bver.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Bver.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Bver.setBackground(null);
			}
		});
		Bver.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
		    		Tnome.setText("");
					Tdata.setText("");
		    		CBtipo.setSelectedIndex(0);
		    		CBlocal.setSelectedIndex(0);
		        	cl.show(Panel_main, "1");
		        	Bvoltar.requestFocus();
					Lnome1.setText(lista.get(0).getNome());
					Ldata1.setText(lista.get(0).getData());
					Llocal1.setText(lista.get(0).getLocal());
					Ltipo1.setText(lista.get(0).getTipo());
					
					Lnome_1.setText(lista.get(1).getNome());
					Ldata_1.setText(lista.get(1).getData());
					Llocal_1.setText(lista.get(1).getLocal());
					Ltipo_1.setText(lista.get(1).getTipo());
					
					Lnome_2.setText(lista.get(2).getNome());
					Ldata_2.setText(lista.get(2).getData());
					Llocal_2.setText(lista.get(2).getLocal());
					Ltipo_2.setText(lista.get(2).getTipo());
		        }
			}
		});
		Bver.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Bver.setBounds(245, 388, 132, 47);
		panel.add(Bver);
	}
}
