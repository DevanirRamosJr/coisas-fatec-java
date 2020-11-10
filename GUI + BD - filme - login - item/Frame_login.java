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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Frame_login extends JFrame {

	private JPanel Panel_main;
	private JTextField Tnome00;
	private JPasswordField Password00;
	private JPasswordField Password01;
	private JTextField Tnome10;
	private JPasswordField Password10;
	private ArrayList nomes;
	private int click;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_login frame = new Frame_login();
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
	public Frame_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 150, 400, 400);
		setResizable(false);
		Panel_main = new JPanel();
		Panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_main);
		Panel_main.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(Panel_main.getLayout());
		
		//criação das telas
		JPanel Panel00 = new JPanel();
		Panel_main.add(Panel00, "0");
		Panel00.setLayout(null);
		
		JPanel Pcadas = new JPanel();
		Panel_main.add(Pcadas, "1");
		Pcadas.setLayout(null);		
		
		JPanel Plogin = new JPanel();
		Panel_main.add(Plogin, "2");
		Plogin.setLayout(null);
		
		JPanel Plogado = new JPanel();
		Panel_main.add(Plogado, "3");
		Plogado.setLayout(null);
		
		JPanel Padmin = new JPanel();
		Panel_main.add(Padmin, "4");
		Padmin.setLayout(null);
		


		
		
		
		//tela inicial
		JLabel lblNewLabel = new JLabel("In\u00EDcio");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 384, 43);
		Panel00.add(lblNewLabel);
		
		JButton Blogin = new JButton("Login");
		Blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(Panel_main, "2");
			}
		});
		Blogin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Blogin.setBounds(125, 134, 137, 50);
		Panel00.add(Blogin);
		
		JButton Bcadas = new JButton("Cadastrar");
		Bcadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(Panel_main, "1");
			}
		});
		Bcadas.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Bcadas.setBounds(125, 232, 137, 50);
		Panel00.add(Bcadas);
		
		
		
		
		nomes = new ArrayList();
		try {
			nomes = get("nome");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//tela de cadastro
		JLabel lblCadastrar = new JLabel("Cadastro");
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblCadastrar.setBounds(0, 10, 384, 43);
		Pcadas.add(lblCadastrar);
		
		JLabel Lnome00 = new JLabel("Nome:");
		Lnome00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lnome00.setBounds(30, 70, 80, 34);
		Pcadas.add(Lnome00);
		
		Tnome00 = new JTextField();
		Tnome00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Tnome00.setBounds(30, 105, 325, 30);
		Pcadas.add(Tnome00);
		Tnome00.setColumns(10);
		
		JLabel Lsenha00 = new JLabel("Senha:");
		Lsenha00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lsenha00.setBounds(30, 145, 258, 34);
		Pcadas.add(Lsenha00);
		
		JLabel Lsenha01 = new JLabel("Senha:");
		Lsenha01.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lsenha01.setBounds(30, 220, 96, 34);
		Pcadas.add(Lsenha01);
		
		Password00 = new JPasswordField();
		Password00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Password00.setBounds(30, 180, 325, 30);
		Pcadas.add(Password00);
		
		Password01 = new JPasswordField();
		Password01.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Password01.setBounds(30, 255, 325, 30);
		Pcadas.add(Password01);
		
		JLabel Laviso = new JLabel("");
		Laviso.setForeground(Color.RED);
		Laviso.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Laviso.setBounds(136, 220, 219, 34);
		Pcadas.add(Laviso);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomes = new ArrayList();
				try {
					nomes = get("nome");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (nomes.contains(Tnome00.getText())) {
					Laviso.setText("*esse nome já existe");
				}
				//compara os dois campos Password
				//usa Arrays.equals porque .getPassword() retorna um array 
				else if (Arrays.equals(Password00.getPassword(), Password01.getPassword()) && String.valueOf(Password00.getPassword()).length() > 5 && Tnome00.getText().length() > 4) {
					Login login = new Login(String.valueOf(Tnome00.getText()), String.valueOf(Password00.getPassword()));
					try {
						post(login.getNome(), login.getSenha());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Tnome00.setText("");
					Password00.setText("");
					Password01.setText("");
					Laviso.setText("");
					cl.show(Panel_main, "0");
				}
				else {
					if (String.valueOf(Password00.getPassword()).length() < 6) {
						Laviso.setText("*senha menor que 6 caracteres");
					}
					else if (Tnome00.getText().length() > 4){
						Laviso.setText("*nome menor que 4 caracteres");
					}
					else {
						Laviso.setText("*as senhas não são iguais");
					}	
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(131, 300, 123, 41);
		Pcadas.add(btnNewButton);
		
		JButton btnVoltar0 = new JButton("Voltar");
		btnVoltar0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tnome00.setText("");
				Password00.setText("");
				Password01.setText("");
				Laviso.setText("");
				cl.show(Panel_main, "0");	
			}
		});
		btnVoltar0.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnVoltar0.setBounds(5, 10, 61, 20);
		Pcadas.add(btnVoltar0);
		

		
		
		
		//tela de login
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblLogin.setBounds(0, 10, 384, 45);
		Plogin.add(lblLogin);
		
		JLabel Lnome10 = new JLabel("Nome:");
		Lnome10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lnome10.setBounds(30, 76, 80, 34);
		Plogin.add(Lnome10);
		
		Tnome10 = new JTextField();
		Tnome10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Tnome10.setColumns(10);
		Tnome10.setBounds(30, 115, 325, 30);
		Plogin.add(Tnome10);
		
		JLabel Lsenha10 = new JLabel("Senha:");
		Lsenha10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lsenha10.setBounds(30, 170, 80, 34);
		Plogin.add(Lsenha10);
			
		JLabel Laviso10 = new JLabel("");
		Laviso10.setForeground(Color.RED);
		Laviso10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Laviso10.setBounds(173, 170, 182, 34);
		Plogin.add(Laviso10);
				
		Password10 = new JPasswordField();
		Password10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Password10.setBounds(30, 210, 325, 30);
		Plogin.add(Password10);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomes = new ArrayList();
				ArrayList senhas = new ArrayList();
				try {
					nomes = get("nome");
					senhas = get("senha");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (nomes.indexOf(Tnome10.getText()) == -1) {
					Laviso10.setText("*senha e/ou login errado");
				}
				else if (String.valueOf(Password10.getPassword()).equals(senhas.get(nomes.indexOf(Tnome10.getText())))) {
					if (Tnome10.getText().equals("admin")) {
						cl.show(Panel_main, "4");
					}
					else {
						Tnome10.setText("");
						Password10.setText("");
						Laviso10.setText("");
						cl.show(Panel_main, "3");
					}

				}
				else {
					Laviso10.setText("*senha e/ou login errado");
				}
					
			}
		});
		btnLogar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogar.setBounds(130, 284, 123, 41);
		Plogin.add(btnLogar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tnome10.setText("");
				Password10.setText("");
				Laviso10.setText("");
				cl.show(Panel_main, "0");	
			}
		});
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnVoltar.setBounds(5, 10, 61, 20);
		Plogin.add(btnVoltar);
		
		
		
		
		
		//tela logado
		JLabel lblLogado = new JLabel("Logado");
		lblLogado.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogado.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblLogado.setBounds(0, 11, 384, 45);
		Plogado.add(lblLogado);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(Panel_main, "0");
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1.setBounds(130, 270, 125, 51);
		Plogado.add(btnNewButton_1);
		
		
		
		
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblAdmin.setBounds(0, 10, 384, 45);
		Padmin.add(lblAdmin);
		
		JLabel Lnome40 = new JLabel("Nome:");
		Lnome40.setHorizontalAlignment(SwingConstants.CENTER);
		Lnome40.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		Lnome40.setBounds(0, 76, 384, 34);
		Padmin.add(Lnome40);
		
		JLabel Lnome41 = new JLabel("Nome:");
		Lnome41.setHorizontalAlignment(SwingConstants.CENTER);
		Lnome41.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		Lnome41.setBounds(0, 121, 384, 54);
		Padmin.add(Lnome41);
		
		JButton Bsair = new JButton("Sair");
		Bsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(Panel_main, "0");
			}
		});
		Bsair.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Bsair.setBounds(22, 260, 101, 51);
		Padmin.add(Bsair);
		
		JButton Bdel = new JButton("Apagar");
		Bdel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Lnome41.getText().equals("admin")) {
				}
				else {
					try {
						delete(Lnome41.getText());
						nomes = get("nome");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		Bdel.setFont(new Font("Times New Roman", Font.BOLD, 21));
		Bdel.setBounds(259, 261, 101, 51);
		Padmin.add(Bdel);
		
		
		click = 0;
		Lnome41.setText(String.valueOf(nomes.get(click)));
		JButton Bprox = new JButton("Prox.");
		Bprox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click += 1;
				if (click > nomes.size() - 1) {
					click = 0;
				}
				Lnome41.setText(String.valueOf(nomes.get(click)));
			}
		});
		Bprox.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Bprox.setBounds(139, 260, 101, 51);
		Padmin.add(Bprox);
		
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
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS login (\r\n" + 
					"    nome VARCHAR(30) PRIMARY KEY,\r\n" + 
					"    senha VARCHAR(25) NOT NULL\r\n" + 
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
	
	public static void post(String nome, String senha) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO login VALUES('" + nome + "','" + senha + "')");
			posted.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch do post " + e);
		}
		finally {
			System.out.println("dados inseridos");
		}
	}
	
	public static void delete(String nome) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement changed = con.prepareStatement("DELETE FROM login WHERE nome = '" + nome + "'");
			changed.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch do delete " + e);
		}
		finally {
			System.out.println("dados deletados");
		}
		
	}
	
	public static ArrayList get(String coluna) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement tabela = con.prepareStatement("SELECT * FROM login");
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
