package ling1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	
	private int click;
	private ArrayList<Filme> lista;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		getConnection();
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
		
		setTitle("Lista de Assistidos");
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
	
		JPanel panel_edit = new JPanel();
		Panel_main.add(panel_edit,"2");
		panel_edit.setLayout(null);
		
		
		
		
		
		JLabel Ltitle0 = new JLabel("Lista de Filmes/S\u00E9ries");
		Ltitle0.setHorizontalAlignment(SwingConstants.CENTER);
		Ltitle0.setFont(new Font("Times New Roman", Font.BOLD, 30));
		Ltitle0.setBounds(0, 10, 434, 36);
		panel.add(Ltitle0);
		
		JLabel Lnome0 = new JLabel("T\u00EDtulo:");
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
		
		JLabel Ltipo0 = new JLabel("Tipo:");
		Ltipo0.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ltipo0.setBounds(10, 153, 140, 24);
		panel.add(Ltipo0);
		
		String[] tipos = {"Selecione", "Filme", "Série", "Documentário", "Anime", "Dorama", "Desenho", "Show"};
		JComboBox CBtipo = new JComboBox(tipos);
		CBtipo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		CBtipo.setBounds(10, 188, 145, 30);
		panel.add(CBtipo);
		CBtipo.setSelectedIndex(0);
		
		JLabel Ldata0 = new JLabel("Data:");
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
		
		JLabel Llocal0 = new JLabel("Onde:");
		Llocal0.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Llocal0.setBounds(10, 302, 140, 24);
		panel.add(Llocal0);
		
		String[] locais = {"Selecione", "Netflix", "Prime Video", "Disney+", "Hulu", "Globo Play", "Crunchyroll", "Outro"};
		JComboBox CBlocal = new JComboBox(locais);
		CBlocal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		CBlocal.setBounds(10, 337, 145, 30);
		panel.add(CBlocal);
		
		
		
		
		JButton Badd = new JButton("Adicionar");
		Badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Tnome.getText().equals("") || Tdata.getText().equals("") || CBlocal.getSelectedIndex() == 0 || CBtipo.getSelectedIndex() == 0) {
				}
				else {
					Filme movie = new Filme(Tnome.getText(), Tdata.getText(), locais[CBlocal.getSelectedIndex()], tipos[CBtipo.getSelectedIndex()]);				
					try {
						post(movie.getNome(), movie.getData(), movie.getLocal(), movie.getTipo());
					} catch (Exception e) {
						System.out.println("catch do botao " + e);;
					}
					Tnome.setText("");
					Tdata.setText("");
					CBtipo.setSelectedIndex(0);
					CBlocal.setSelectedIndex(0);
					Tnome.requestFocus();
				}
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
					if (Tnome.getText().equals("") || Tdata.getText().equals("") || CBlocal.getSelectedIndex() == 0 || CBtipo.getSelectedIndex() == 0) {
					}
					else {
						Filme movie = new Filme(Tnome.getText(), Tdata.getText(), locais[CBlocal.getSelectedIndex()], tipos[CBtipo.getSelectedIndex()]);				
						try {
							post(movie.getNome(), movie.getData(), movie.getLocal(), movie.getTipo());
						} catch (Exception e1) {
							System.out.println("catch do botao " + e1);
						}
						Tnome.setText("");
						Tdata.setText("");
						CBtipo.setSelectedIndex(0);
						CBlocal.setSelectedIndex(0);
						Tnome.requestFocus();
					}		        	
		        }
			}
		});
		Badd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Badd.setBounds(15, 388, 115, 47);
		panel.add(Badd);
		
		
		
		
		JButton Bvoltar = new JButton("Voltar");
		Bvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.add(Ltitle0);
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
		        	panel.add(Ltitle0);
		        	cl.show(Panel_main, "0");
		        	Tnome.requestFocus();
		        	click = 0;
		        }
			}
		});
		Bvoltar.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Bvoltar.setBounds(50, 388, 132, 47);
		panel_ver.add(Bvoltar);
		
		JLabel Lnome1 = new JLabel("T\u00EDtulo:");
		Lnome1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lnome1.setBounds(10, 77, 405, 30);
		panel_ver.add(Lnome1);
		
		JLabel Ldata1 = new JLabel("data");
		Ldata1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ldata1.setBounds(135, 112, 102, 30);
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
		Ltipo_1.setBounds(10, 212, 132, 30);
		panel_ver.add(Ltipo_1);
		
		JLabel Ldata_1 = new JLabel("tipo");
		Ldata_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ldata_1.setBounds(135, 212, 102, 30);
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
		Ltipo_2.setBounds(10, 319, 132, 30);
		panel_ver.add(Ltipo_2);
		
		JLabel Ldata_2 = new JLabel("tipo");
		Ldata_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ldata_2.setBounds(135, 319, 102, 30);
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
				lista.clear();
				try {											
					ArrayList nomes = new ArrayList();
					ArrayList tipos = new ArrayList();
					ArrayList datas = new ArrayList();
					ArrayList locais = new ArrayList();
					nomes = get("nome");
					tipos = get("tipo");
					datas = get("dia");
					locais = get("onde");
					for (int i = 0; i < nomes.size(); i++) {
						Filme movie = new Filme(String.valueOf(nomes.get(i)), String.valueOf(datas.get(i)), String.valueOf(locais.get(i)), String.valueOf(tipos.get(i)));
						lista.add(movie);
						System.out.println(lista.get(i).getNome());
						//System.out.println(nomes.get(i) + ", " + tipos.get(i) + ", " + datas.get(i) + ", " + locais.get(i));
					}
				} catch (Exception e1) {
					System.out.println("erro no botao get " + e1);
				}
	    		Tnome.setText("");
				Tdata.setText("");
	    		CBtipo.setSelectedIndex(0);
	    		CBlocal.setSelectedIndex(0);
	    		panel_ver.add(Ltitle0);
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
					lista.clear();
					try {											
						ArrayList nomes = new ArrayList();
						ArrayList tipos = new ArrayList();
						ArrayList datas = new ArrayList();
						ArrayList locais = new ArrayList();
						nomes = get("nome");
						tipos = get("tipo");
						datas = get("dia");
						locais = get("onde");
						for (int i = 0; i < nomes.size(); i++) {
							Filme movie = new Filme(String.valueOf(nomes.get(i)), String.valueOf(datas.get(i)), String.valueOf(locais.get(i)), String.valueOf(tipos.get(i)));
							lista.add(movie);
							System.out.println(lista.get(i).getNome());
							//System.out.println(nomes.get(i) + ", " + tipos.get(i) + ", " + datas.get(i) + ", " + locais.get(i));
						}
					} catch (Exception e1) {
						System.out.println("erro no botao get " + e1);
					}
		    		Tnome.setText("");
					Tdata.setText("");
		    		CBtipo.setSelectedIndex(0);
		    		CBlocal.setSelectedIndex(0);
		    		panel_ver.add(Ltitle0);
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
		Bver.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Bver.setBounds(155, 388, 115, 47);
		panel.add(Bver);
		
		
		
		
		JButton Bvoltar1 = new JButton("Voltar");
		Bvoltar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.add(Ltitle0);
				panel.add(Lnome0);
				Lnome0.setForeground(Color.BLACK);
				panel.add(Tnome);
				Tnome.setForeground(Color.BLACK);
				panel.add(Ldata0);
				Ldata0.setForeground(Color.BLACK);
				panel.add(Tdata);
				Tdata.setForeground(Color.BLACK);
				panel.add(Ltipo0);
				Ltipo0.setForeground(Color.BLACK);
				panel.add(CBtipo);
				CBtipo.setForeground(Color.BLACK);
				panel.add(Llocal0);
				Llocal0.setForeground(Color.BLACK);
				panel.add(CBlocal);
				CBlocal.setForeground(Color.BLACK);
				cl.show(Panel_main, "0");
				panel_ver.add(Bvoltar);
				Tnome.setText("");
				Tdata.setText("");
				CBtipo.setSelectedIndex(0);
				CBlocal.setSelectedIndex(0);
				Tnome.requestFocus();
				click = 0;
			}
		});
		Bvoltar1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Bvoltar1.setBackground(Color.LIGHT_GRAY);	
			}
			@Override
			public void focusLost(FocusEvent e) {
				Bvoltar1.setBackground(null);
			}
		});
		Bvoltar1.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
					panel.add(Ltitle0);
					panel.add(Lnome0);
					Lnome0.setForeground(Color.BLACK);
					panel.add(Tnome);
					Tnome.setForeground(Color.BLACK);
					panel.add(Ldata0);
					Ldata0.setForeground(Color.BLACK);
					panel.add(Tdata);
					Tdata.setForeground(Color.BLACK);
					panel.add(Ltipo0);
					Ltipo0.setForeground(Color.BLACK);
					panel.add(CBtipo);
					CBtipo.setForeground(Color.BLACK);
					panel.add(Llocal0);
					Llocal0.setForeground(Color.BLACK);
					panel.add(CBlocal);
					CBlocal.setForeground(Color.BLACK);
					cl.show(Panel_main, "0");
					panel_ver.add(Bvoltar);
					Tnome.setText("");
					Tdata.setText("");
					CBtipo.setSelectedIndex(0);
					CBlocal.setSelectedIndex(0);
					Tnome.requestFocus();
					click = 0;
		        }
			}
		});
		Bvoltar1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Bvoltar1.setBounds(10, 388, 90, 47);
		panel_edit.add(Bvoltar1);
		
		
		
		
		JButton Bedit = new JButton("Editar");
		Bedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_edit.add(Ltitle0);
				panel_edit.add(Lnome0);
				Lnome0.setForeground(Color.MAGENTA);
				panel_edit.add(Tnome);
				Tnome.setForeground(Color.MAGENTA);
				panel_edit.add(Ldata0);
				Ldata0.setForeground(Color.MAGENTA);
				panel_edit.add(Tdata);
				Tdata.setForeground(Color.MAGENTA);
				panel_edit.add(Ltipo0);
				Ltipo0.setForeground(Color.MAGENTA);
				panel_edit.add(CBtipo);
				CBtipo.setForeground(Color.MAGENTA);
				panel_edit.add(Llocal0);
				Llocal0.setForeground(Color.MAGENTA);
				panel_edit.add(CBlocal);
				CBlocal.setForeground(Color.MAGENTA);
				
				lista.clear();
				try {											
					ArrayList nomes = new ArrayList();
					ArrayList tipos = new ArrayList();
					ArrayList datas = new ArrayList();
					ArrayList locais = new ArrayList();
					nomes = get("nome");
					tipos = get("tipo");
					datas = get("dia");
					locais = get("onde");
					for (int i = 0; i < nomes.size(); i++) {
						Filme movie = new Filme(String.valueOf(nomes.get(i)), String.valueOf(datas.get(i)), String.valueOf(locais.get(i)), String.valueOf(tipos.get(i)));
						lista.add(movie);
						System.out.println(lista.get(i).getNome());
						//System.out.println(nomes.get(i) + ", " + tipos.get(i) + ", " + datas.get(i) + ", " + locais.get(i));
					}
				} catch (Exception e) {
					System.out.println("erro no botao get " + e);
				}
				click = 0;
				Tnome.setText(lista.get(click).getNome());
				Tdata.setText(lista.get(click).getData());
				CBtipo.setSelectedItem(lista.get(click).getTipo());
				CBlocal.setSelectedItem(lista.get(click).getLocal());

				cl.show(Panel_main, "2");
				Tnome.requestFocus();
			}
		});
		Bedit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Bedit.setBackground(Color.LIGHT_GRAY);	
			}
			@Override
			public void focusLost(FocusEvent e) {
				Bedit.setBackground(null);
			}
		});
		Bedit.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
					panel_edit.add(Ltitle0);
					panel_edit.add(Lnome0);
					Lnome0.setForeground(Color.MAGENTA);
					panel_edit.add(Tnome);
					Tnome.setForeground(Color.MAGENTA);
					panel_edit.add(Ldata0);
					Ldata0.setForeground(Color.MAGENTA);
					panel_edit.add(Tdata);
					Tdata.setForeground(Color.MAGENTA);
					panel_edit.add(Ltipo0);
					Ltipo0.setForeground(Color.MAGENTA);
					panel_edit.add(CBtipo);
					CBtipo.setForeground(Color.MAGENTA);
					panel_edit.add(Llocal0);
					Llocal0.setForeground(Color.MAGENTA);
					panel_edit.add(CBlocal);
					CBlocal.setForeground(Color.MAGENTA);
					
					lista.clear();
					try {											
						ArrayList nomes = new ArrayList();
						ArrayList tipos = new ArrayList();
						ArrayList datas = new ArrayList();
						ArrayList locais = new ArrayList();
						nomes = get("nome");
						tipos = get("tipo");
						datas = get("dia");
						locais = get("onde");
						for (int i = 0; i < nomes.size(); i++) {
							Filme movie = new Filme(String.valueOf(nomes.get(i)), String.valueOf(datas.get(i)), String.valueOf(locais.get(i)), String.valueOf(tipos.get(i)));
							lista.add(movie);
							System.out.println(lista.get(i).getNome());
							//System.out.println(nomes.get(i) + ", " + tipos.get(i) + ", " + datas.get(i) + ", " + locais.get(i));
						}
					} catch (Exception e1) {
						System.out.println("erro no botao get " + e1);
					}
					click = 0;
					Tnome.setText(lista.get(click).getNome());
					Tdata.setText(lista.get(click).getData());
					CBtipo.setSelectedItem(lista.get(click).getTipo());
					CBlocal.setSelectedItem(lista.get(click).getLocal());

					cl.show(Panel_main, "2");
					Tnome.requestFocus();
		        }
			}
		});
		Bedit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Bedit.setBounds(295, 388, 115, 47);
		panel.add(Bedit);
		
		
		
		
		JButton Bant = new JButton("Ant.");
		Bant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (click == 0) {
					click = lista.size() - 1;
					Tnome.setText(lista.get(click).getNome());
					Tdata.setText(lista.get(click).getData());
					CBtipo.setSelectedItem(lista.get(click).getTipo());
					CBlocal.setSelectedItem(lista.get(click).getLocal());
				}
				else {
					click -= 1;
					Tnome.setText(lista.get(click).getNome());
					Tdata.setText(lista.get(click).getData());
					CBtipo.setSelectedItem(lista.get(click).getTipo());
					CBlocal.setSelectedItem(lista.get(click).getLocal());
				}
			}
		});
		Bant.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Bant.setBackground(Color.LIGHT_GRAY);	
			}
			@Override
			public void focusLost(FocusEvent e) {
				Bant.setBackground(null);
			}
		});
		Bant.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
					if (click == 0) {
						click = lista.size() - 1;
						Tnome.setText(lista.get(click).getNome());
						Tdata.setText(lista.get(click).getData());
						CBtipo.setSelectedItem(lista.get(click).getTipo());
						CBlocal.setSelectedItem(lista.get(click).getLocal());
					}
					else {
						click -= 1;
						Tnome.setText(lista.get(click).getNome());
						Tdata.setText(lista.get(click).getData());
						CBtipo.setSelectedItem(lista.get(click).getTipo());
						CBlocal.setSelectedItem(lista.get(click).getLocal());
					}
		        }
			}
		});
		Bant.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Bant.setBounds(115, 388, 90, 47);
		panel_edit.add(Bant);
		
		JButton Bprox = new JButton("Prox");
		Bprox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (click == lista.size() - 1) {
					click = 0;
					Tnome.setText(lista.get(click).getNome());
					Tdata.setText(lista.get(click).getData());
					CBtipo.setSelectedItem(lista.get(click).getTipo());
					CBlocal.setSelectedItem(lista.get(click).getLocal());
				}
				else {
					click += 1;
					Tnome.setText(lista.get(click).getNome());
					Tdata.setText(lista.get(click).getData());
					CBtipo.setSelectedItem(lista.get(click).getTipo());
					CBlocal.setSelectedItem(lista.get(click).getLocal());
				}
			}
		});
		Bprox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Bprox.setBackground(Color.LIGHT_GRAY);	
			}
			@Override
			public void focusLost(FocusEvent e) {
				Bprox.setBackground(null);
			}
		});
		Bprox.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
					if (click == lista.size() - 1) {
						click = 0;
						Tnome.setText(lista.get(click).getNome());
						Tdata.setText(lista.get(click).getData());
						CBtipo.setSelectedItem(lista.get(click).getTipo());
						CBlocal.setSelectedItem(lista.get(click).getLocal());
					}
					else {
						click += 1;
						Tnome.setText(lista.get(click).getNome());
						Tdata.setText(lista.get(click).getData());
						CBtipo.setSelectedItem(lista.get(click).getTipo());
						CBlocal.setSelectedItem(lista.get(click).getLocal());
					}
		        }
			}
		});
		Bprox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Bprox.setBounds(220, 388, 90, 47);
		panel_edit.add(Bprox);
		
		JButton Bchange = new JButton("Mudar");
		Bchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					change("dia", "nome", lista.get(click).getNome(), Tdata.getText());
					change("tipo", "nome", lista.get(click).getNome(), tipos[CBtipo.getSelectedIndex()]);
					change("onde", "nome", lista.get(click).getNome(), locais[CBlocal.getSelectedIndex()]);
					change("nome", "nome", lista.get(click).getNome(), Tnome.getText());
					
					lista.clear();
					ArrayList nomes = new ArrayList();
					ArrayList tipos = new ArrayList();
					ArrayList datas = new ArrayList();
					ArrayList locais = new ArrayList();
					nomes = get("nome");
					tipos = get("tipo");
					datas = get("dia");
					locais = get("onde");
					for (int i = 0; i < nomes.size(); i++) {
						Filme movie = new Filme(String.valueOf(nomes.get(i)), String.valueOf(datas.get(i)), String.valueOf(locais.get(i)), String.valueOf(tipos.get(i)));
						lista.add(movie);
					}
					click = nomes.indexOf(Tnome.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Bchange.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Bchange.setBackground(Color.LIGHT_GRAY);	
			}
			@Override
			public void focusLost(FocusEvent e) {
				Bchange.setBackground(null);
			}
		});
		Bchange.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
					try {
						change("dia", "nome", lista.get(click).getNome(), Tdata.getText());
						change("tipo", "nome", lista.get(click).getNome(), tipos[CBtipo.getSelectedIndex()]);
						change("onde", "nome", lista.get(click).getNome(), locais[CBlocal.getSelectedIndex()]);
						change("nome", "nome", lista.get(click).getNome(), Tnome.getText());
						
						lista.clear();
						ArrayList nomes = new ArrayList();
						ArrayList tipos = new ArrayList();
						ArrayList datas = new ArrayList();
						ArrayList locais = new ArrayList();
						nomes = get("nome");
						tipos = get("tipo");
						datas = get("dia");
						locais = get("onde");
						for (int i = 0; i < nomes.size(); i++) {
							Filme movie = new Filme(String.valueOf(nomes.get(i)), String.valueOf(datas.get(i)), String.valueOf(locais.get(i)), String.valueOf(tipos.get(i)));
							lista.add(movie);
						}
						click = nomes.indexOf(Tnome.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
			}
		});
		Bchange.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Bchange.setBounds(325, 388, 90, 47);
		panel_edit.add(Bchange);
		
	}
	
	
	
	
	
	public static Connection getConnection() throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/filme?useTimezone=true&serverTimezone=UTC";
			String username = "root";
			String password = "password";
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Conectado");
			return con;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void createTable() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS filme (\r\n" + 
					"    nome VARCHAR(50) PRIMARY KEY,\r\n" + 
					"    tipo VARCHAR(20),\r\n" + 
					"    dia VARCHAR(10),\r\n" + 
					"    onde VARCHAR(20)\r\n" + 
					")");
			create.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch da criação " + e);
		}
		finally {
			System.out.println("tabela criada");
		}
	}
	
	public static void post(String nome, String data, String local, String tipo) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO filme VALUES('" + nome + "','" + tipo + "','" + data + "','" + local + "')" );
			posted.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch do post " + e);
		}
		finally {
			System.out.println("dados inseridos");
		}
	}
	
	public static void change(String coluna, String onde, String onde_igual, String novo) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement changed = con.prepareStatement("UPDATE filme SET " + coluna + " = '"+ novo + "' WHERE " + onde + " = '" + onde_igual + "'");
			changed.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch do change " + e);
		}
		finally {
			System.out.println("dados mudados");
		}
		
	}
	
	public static ArrayList get(String coluna) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement tabela = con.prepareStatement("SELECT * FROM filme");
			ResultSet resultado = tabela.executeQuery();
		
			ArrayList array = new ArrayList();
			while (resultado.next()) {
				array.add(resultado.getString(coluna));
			}
		
			System.out.println("Get finalizado");
			return array;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}
}
