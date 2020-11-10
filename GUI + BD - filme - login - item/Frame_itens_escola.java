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
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Frame_itens_escola extends JFrame {

	private JPanel Panel_main;
	private JTextField Titem;
	private ArrayList coisas;

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
		try {
			coisas = get("nome");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
				String str = Titem.getText();
				String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
				try {
					coisas = get("nome");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (Titem.getText().equals("")) {
					Laviso.setText("");
				}
				else if (coisas.contains(cap)) {
					Laviso.setForeground(Color.RED);
					Laviso.setText("Esse item já tem");
				}
				else {
					try {
						post(cap);
						coisas = get("nome");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Laviso.setForeground(Color.BLACK);
					Laviso.setText(cap + " adicionado");
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
				String str = Titem.getText();
				String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
				if (coisas.contains(cap)) {
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
				String str = Titem.getText();
				String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
				if (coisas.contains(cap)) {
					try {
						delete(cap);
						coisas = get("nome");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Laviso.setForeground(Color.BLACK);
					Laviso.setText(cap + " removido da lista");
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
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS item (\r\n" + 
					"    nome VARCHAR(25) PRIMARY KEY\r\n" + 
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
	
	public static void post(String nome) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO item VALUES('" + nome + "')");
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
			PreparedStatement changed = con.prepareStatement("DELETE FROM item WHERE nome = '" + nome + "'");
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
			PreparedStatement tabela = con.prepareStatement("SELECT * FROM item");
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
