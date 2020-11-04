package ling1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Exemplo_PI extends JFrame {

	private JPanel contentPane;
	private JTextField Tnome;
	private JTextField Tinstalacao;
	private JTextField Tvalor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exemplo_PI frame = new Exemplo_PI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Exemplo_PI() throws Exception {
		getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conta");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 568, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 70, 69, 24);
		contentPane.add(lblNewLabel_1);
		
		Tnome = new JTextField();
		Tnome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Tnome.setBounds(20, 100, 151, 30);
		contentPane.add(Tnome);
		Tnome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Instala\u00E7\u00E3o");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(263, 70, 117, 24);
		contentPane.add(lblNewLabel_1_1);
		
		Tinstalacao = new JTextField();
		Tinstalacao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Tinstalacao.setColumns(10);
		Tinstalacao.setBounds(263, 100, 151, 30);
		contentPane.add(Tinstalacao);
		
		JLabel lblNewLabel_1_2 = new JLabel("Valor");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(20, 144, 69, 24);
		contentPane.add(lblNewLabel_1_2);
		
		Tvalor = new JTextField();
		Tvalor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Tvalor.setBounds(20, 175, 117, 30);
		contentPane.add(Tvalor);
		Tvalor.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = Tnome.getText();
				int numero = Integer.parseInt(Tinstalacao.getText());
				int valor = Integer.parseInt(Tvalor.getText());
				try {
					post(nome, numero, valor);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Tnome.setText("");
				Tinstalacao.setText("");
				Tvalor.setText("");
			}
		});
		btnNewButton.setBounds(263, 172, 117, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("______________________________________________");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(10, 223, 568, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel Lnome1 = new JLabel("Nome");
		Lnome1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lnome1.setBounds(20, 268, 86, 24);
		contentPane.add(Lnome1);
		
		JLabel Linstalacao1 = new JLabel("Instala\u00E7\u00E3o");
		Linstalacao1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Linstalacao1.setBounds(216, 268, 117, 24);
		contentPane.add(Linstalacao1);
		
		JLabel Lvalor1 = new JLabel("Valor");
		Lvalor1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lvalor1.setBounds(426, 268, 69, 24);
		contentPane.add(Lvalor1);
		
		JLabel Lvalor2 = new JLabel("Valor");
		Lvalor2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lvalor2.setBounds(426, 324, 69, 24);
		contentPane.add(Lvalor2);
		
		JLabel Linstalacao2 = new JLabel("Instala\u00E7\u00E3o");
		Linstalacao2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Linstalacao2.setBounds(216, 324, 117, 24);
		contentPane.add(Linstalacao2);
		
		JLabel Lnome2 = new JLabel("Nome");
		Lnome2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lnome2.setBounds(20, 324, 86, 24);
		contentPane.add(Lnome2);
		
		JLabel Lvalor3 = new JLabel("Valor");
		Lvalor3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lvalor3.setBounds(426, 388, 69, 24);
		contentPane.add(Lvalor3);
		
		JLabel Linstalacao3 = new JLabel("Instala\u00E7\u00E3o");
		Linstalacao3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Linstalacao3.setBounds(216, 388, 117, 24);
		contentPane.add(Linstalacao3);
		
		JLabel Lnome3 = new JLabel("Nome");
		Lnome3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Lnome3.setBounds(20, 388, 86, 24);
		contentPane.add(Lnome3);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Lnome1.setText(getLinha(1, "nome"));
					Linstalacao1.setText(getLinha(1, "instalacao"));
					Lvalor1.setText(getLinha(1, "valor"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnVer.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnVer.setBounds(438, 172, 117, 40);
		contentPane.add(btnVer);
	}
	
	
	
	
	
	
	//método que conecta o programa com mysql
	public static Connection getConnection() throws Exception {
		try {
			//jdbc:mysql://localhost:3306/NOME_DATABASE?useTimezone=true&serverTimezone=UTC
			//?useTimezone=true&serverTimezone=UTC   -  usa se estiver dando erro de timezone/fuso horário
			String url = "jdbc:mysql://localhost:3306/exemplo?useTimezone=true&serverTimezone=UTC";
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
	
	//método para criar tabelas
	public static void createTable() throws Exception {
		try {
			Connection con = getConnection();
			//con.prepareStatement("COMANDO SQL")
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS conta(id int PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(50), instalacao INT, valor INT)");
			create.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch da criação " + e);
		}
		finally {
			System.out.println("tabela criada");
		}
	}
	
	//método para inserir dados na tabela
	public static void post(String nome, int numero, int valor) throws Exception {
		try {
			Connection con = getConnection();
			//con.prepareStatement("COMANDO SQL")
			PreparedStatement posted = con.prepareStatement("INSERT INTO conta (nome, instalacao, valor) VALUES('" + nome + "'," + numero + "," + valor + ")" );
			posted.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch do post " + e);
		}
		finally {
			System.out.println("dados inseridos");
		}
	}
	
	//método que pega os dados de uma coluna da tabela
	public static ArrayList getColuna(String coluna) throws Exception{
		try {
			Connection con = getConnection();
			//con.prepareStatement("COMANDO SQL")
			PreparedStatement tabela = con.prepareStatement("SELECT * FROM conta");
			ResultSet resultado = tabela.executeQuery();
		
			ArrayList array = new ArrayList();
			while (resultado.next()) {
				array.add(resultado.getString(coluna));
				System.out.println(resultado.getString(coluna));
				//System.out.println(resultado);
			}
			System.out.println("Get finalizado");
			return array;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}
	
	public static String getLinha(int id, String coluna) throws Exception{
		try {
			Connection con = getConnection();
			//con.prepareStatement("COMANDO SQL")
			PreparedStatement tabela = con.prepareStatement("SELECT * FROM conta WHERE conta.id = " + id);
			ResultSet resultado = tabela.executeQuery();
			System.out.println(resultado.getFetchSize());
			String s = null;
			while (resultado.next()) {
				s = String.valueOf(resultado.getString(coluna));
			}
			System.out.println("Get finalizado");
			return s;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}
}
