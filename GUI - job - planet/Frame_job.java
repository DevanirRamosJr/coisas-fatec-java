package ling1;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;


public class Frame_job extends JFrame {

	private char sexo;
	private String nome;
	private int idade;
	private int money;
	private String job;
	private int input;
	private int counter;
	private int click;
	
	private JPanel Panel00;
	private JTextField Tnome;
	private JTextField Tidade;
	private JTextField Tjob;
	private JTextField Tmoney;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_job frame = new Frame_job();
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
	public Frame_job() {
		counter = 0;
		click = 0;
		Job[] trab = new Job[20];
		setTitle("Cadastro de Profiss\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(370, 200, 463, 381);
		Panel00 = new JPanel();
		Panel00.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel00);
		Panel00.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(Panel00.getLayout());
		
		//card0
		JPanel card0 = new JPanel();
		Panel00.add(card0, "0");
		card0.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Profiss\u00F5es");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 11, 437, 55);
		card0.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//muda a carta
				cl.show(Panel00, "1");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(123, 174, 187, 55);
		card0.add(btnNewButton);
		
		
		//card1
		JPanel card1 = new JPanel();
		Panel00.add(card1, "1");
		card1.setLayout(null);
		
		JLabel Lnome = new JLabel("Nome:");
		Lnome.setHorizontalAlignment(SwingConstants.LEFT);
		Lnome.setForeground(Color.BLACK);
		Lnome.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lnome.setBounds(10, 11, 88, 28);
		card1.add(Lnome);
		
		Tnome = new JTextField();
		Tnome.setToolTipText("Digite seu nome");
		Tnome.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Tnome.setBounds(10, 42, 244, 28);
		card1.add(Tnome);
		Tnome.setColumns(10);
		
		JLabel Lsexo = new JLabel("Sexo:");
		Lsexo.setHorizontalAlignment(SwingConstants.LEFT);
		Lsexo.setForeground(Color.BLACK);
		Lsexo.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lsexo.setBounds(10, 93, 88, 28);
		card1.add(Lsexo);
		
		JRadioButton radio0 = new JRadioButton("Masculino");
		radio0.setToolTipText("Escolha uma op\u00E7\u00E3o");
		radio0.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				sexo = 'M';
			}
		});
		radio0.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		radio0.setBounds(10, 128, 109, 23);
		card1.add(radio0);
		
		JRadioButton radio1 = new JRadioButton("Feminino");
		radio1.setToolTipText("Escolha uma op\u00E7\u00E3o");
		radio1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				sexo = 'F';
			}
		});
		radio1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		radio1.setBounds(145, 128, 109, 23);
		card1.add(radio1);
		
		JRadioButton radio2 = new JRadioButton("Outro");
		radio2.setToolTipText("Escolha uma op\u00E7\u00E3o");
		radio2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				sexo = 'O';
			}
		});
		radio2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		radio2.setBounds(274, 128, 109, 23);
		card1.add(radio2);
		
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(radio0);
		buttongroup.add(radio1);
		buttongroup.add(radio2);
		
		JLabel Lidade = new JLabel("Idade:");
		Lidade.setHorizontalAlignment(SwingConstants.LEFT);
		Lidade.setForeground(Color.BLACK);
		Lidade.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lidade.setBounds(308, 11, 88, 28);
		card1.add(Lidade);
		
		Tidade = new JTextField();
		Tidade.setToolTipText("Digite sua idade");
		Tidade.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Tidade.setColumns(10);
		Tidade.setBounds(308, 42, 47, 28);
		card1.add(Tidade);
		
		JLabel Ljob = new JLabel("Profiss\u00E3o:");
		Ljob.setHorizontalAlignment(SwingConstants.LEFT);
		Ljob.setForeground(Color.BLACK);
		Ljob.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Ljob.setBounds(10, 169, 109, 28);
		card1.add(Ljob);
		
		Tjob = new JTextField();
		Tjob.setToolTipText("Digite sua profiss\u00E3o");
		Tjob.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Tjob.setColumns(10);
		Tjob.setBounds(10, 203, 244, 28);
		card1.add(Tjob);
		
		JLabel Lmoney = new JLabel("Sal\u00E1rio:");
		Lmoney.setHorizontalAlignment(SwingConstants.LEFT);
		Lmoney.setForeground(Color.BLACK);
		Lmoney.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lmoney.setBounds(308, 169, 88, 28);
		card1.add(Lmoney);
		
		Tmoney = new JTextField();
		Tmoney.setToolTipText("Digite seu sal\u00E1rio");
		Tmoney.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Tmoney.setColumns(10);
		Tmoney.setBounds(308, 203, 109, 28);
		card1.add(Tmoney);
		
		JButton Bfim = new JButton("Concluir");
		Bfim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (buttongroup.getSelection() != null && Tnome.getText() != "" && Tjob.getText() != "") {
					nome = Tnome.getText();
					idade = Integer.parseInt(Tidade.getText());
					job = Tjob.getText();
					money = Integer.parseInt(Tmoney.getText());
					
					input = JOptionPane.showConfirmDialog(null, "Cadastro Realizado\n"
							+ nome + ", " + sexo + ", " + idade + " anos\n"
							+ job + "\n"
							+ "R$" + money, "Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (input == 0) {
						trab[counter] = new Job(nome, sexo, job, idade, money);
						counter += 1;
						cl.show(Panel00, "2");
					}
				}
			}
		});
		Bfim.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Bfim.setBounds(145, 271, 146, 37);
		card1.add(Bfim);
		
		
		//card3
		JPanel card3 = new JPanel();
		Panel00.add(card3, "3");
		card3.setLayout(null);
		
		JLabel L30 = new JLabel("Cadastros Realizados:");
		L30.setHorizontalAlignment(SwingConstants.CENTER);
		L30.setForeground(Color.BLACK);
		L30.setFont(new Font("Times New Roman", Font.BOLD, 26));
		L30.setBounds(10, 11, 417, 44);
		card3.add(L30);
		
		JLabel LshowNome00 = new JLabel("Nome");
		LshowNome00.setHorizontalAlignment(SwingConstants.LEFT);
		LshowNome00.setForeground(Color.BLACK);
		LshowNome00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowNome00.setBounds(10, 79, 211, 28);
		card3.add(LshowNome00);
		
		JLabel LshowSexo00 = new JLabel("Sexo");
		LshowSexo00.setHorizontalAlignment(SwingConstants.LEFT);
		LshowSexo00.setForeground(Color.BLACK);
		LshowSexo00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowSexo00.setBounds(244, 79, 79, 28);
		card3.add(LshowSexo00);
		
		JLabel LshowIdade00 = new JLabel("Idade");
		LshowIdade00.setHorizontalAlignment(SwingConstants.LEFT);
		LshowIdade00.setForeground(Color.BLACK);
		LshowIdade00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowIdade00.setBounds(349, 79, 64, 28);
		card3.add(LshowIdade00);
		
		JLabel LshowJob00 = new JLabel("Job");
		LshowJob00.setHorizontalAlignment(SwingConstants.LEFT);
		LshowJob00.setForeground(Color.BLACK);
		LshowJob00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowJob00.setBounds(10, 112, 211, 28);
		card3.add(LshowJob00);
		
		JLabel LshowMoney00 = new JLabel("Money");
		LshowMoney00.setHorizontalAlignment(SwingConstants.LEFT);
		LshowMoney00.setForeground(Color.BLACK);
		LshowMoney00.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowMoney00.setBounds(244, 112, 99, 28);
		card3.add(LshowMoney00);
		
		JLabel LshowNome10 = new JLabel("");
		LshowNome10.setHorizontalAlignment(SwingConstants.LEFT);
		LshowNome10.setForeground(Color.BLACK);
		LshowNome10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowNome10.setBounds(10, 176, 211, 28);
		card3.add(LshowNome10);
		
		JLabel LshowSexo10 = new JLabel("");
		LshowSexo10.setHorizontalAlignment(SwingConstants.LEFT);
		LshowSexo10.setForeground(Color.BLACK);
		LshowSexo10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowSexo10.setBounds(244, 176, 79, 28);
		card3.add(LshowSexo10);
		
		JLabel LshowIdade10 = new JLabel("");
		LshowIdade10.setHorizontalAlignment(SwingConstants.LEFT);
		LshowIdade10.setForeground(Color.BLACK);
		LshowIdade10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowIdade10.setBounds(349, 176, 64, 28);
		card3.add(LshowIdade10);
		
		JLabel LshowJob10 = new JLabel("");
		LshowJob10.setHorizontalAlignment(SwingConstants.LEFT);
		LshowJob10.setForeground(Color.BLACK);
		LshowJob10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowJob10.setBounds(10, 207, 211, 28);
		card3.add(LshowJob10);
		
		JLabel LshowMoney10 = new JLabel("");
		LshowMoney10.setHorizontalAlignment(SwingConstants.LEFT);
		LshowMoney10.setForeground(Color.BLACK);
		LshowMoney10.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		LshowMoney10.setBounds(244, 207, 99, 28);
		card3.add(LshowMoney10);
		
		JButton Bvoltar = new JButton("Voltar");
		Bvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(Panel00, "2");
			}
		});
		Bvoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Bvoltar.setBounds(69, 261, 111, 47);
		card3.add(Bvoltar);
		
		JButton Bshow = new JButton("Ver Mais");
		Bshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				click += 1;
				if (click < 5) {
					//limpa as labels antes de sobrepor, assim, se n tiver trab criado vai ficar limpo
					LshowNome00.setText("");
					LshowSexo00.setText("");
					LshowIdade00.setText("");
					LshowJob00.setText("");
					LshowMoney00.setText("");
					
					LshowNome10.setText("");
					LshowSexo10.setText("");
					LshowIdade10.setText("");
					LshowJob10.setText("");
					LshowMoney10.setText("");
					
					LshowNome00.setText(trab[click * 2].getNome());
					LshowSexo00.setText(String.valueOf(trab[click * 2].getSexo()));
					LshowIdade00.setText(String.valueOf(trab[click * 2].getAnos()));
					LshowJob00.setText(trab[click * 2].getJob());
					LshowMoney00.setText(String.valueOf(trab[click * 2].getSalario()));

					LshowNome10.setText(trab[click * 2 + 1].getNome());
					LshowSexo10.setText(String.valueOf(trab[click * 2 + 1].getSexo()));
					LshowIdade10.setText(String.valueOf(trab[click * 2 + 1].getAnos()));
					LshowJob10.setText(trab[click * 2 + 1].getJob());
					LshowMoney10.setText(String.valueOf(trab[click * 2 + 1].getSalario()));
				}
				else {
					click = 0;
					LshowNome00.setText(trab[click * 2].getNome());
					LshowSexo00.setText(String.valueOf(trab[click * 2].getSexo()));
					LshowIdade00.setText(String.valueOf(trab[click * 2].getAnos()));
					LshowJob00.setText(trab[click * 2].getJob());
					LshowMoney00.setText(String.valueOf(trab[click * 2].getSalario()));

					LshowNome10.setText(trab[click * 2 + 1].getNome());
					LshowSexo10.setText(String.valueOf(trab[click * 2 + 1].getSexo()));
					LshowIdade10.setText(String.valueOf(trab[click * 2 + 1].getAnos()));
					LshowJob10.setText(trab[click * 2 + 1].getJob());
					LshowMoney10.setText(String.valueOf(trab[click * 2 + 1].getSalario()));
				}
			}
		});
		Bshow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Bshow.setBounds(263, 261, 111, 47);
		card3.add(Bshow);
		
		
		
		
		//card2
		JPanel card2 = new JPanel();
		Panel00.add(card2, "2");
		card2.setLayout(null);
		
		JLabel L20 = new JLabel("O que deseja fazer agora?");
		L20.setHorizontalAlignment(SwingConstants.CENTER);
		L20.setForeground(Color.BLACK);
		L20.setFont(new Font("Times New Roman", Font.BOLD, 26));
		L20.setBounds(10, 11, 417, 47);
		card2.add(L20);
		
		JButton B20 = new JButton("Novo Cadastro");
		B20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tnome.setText("");
				Tidade.setText("");
				Tjob.setText("");
				Tmoney.setText("");
				buttongroup.clearSelection();
				cl.show(Panel00, "1");
			}
		});
		B20.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		B20.setBounds(30, 167, 165, 42);
		card2.add(B20);
		
		JButton B21 = new JButton("Ver Cadastros");
		B21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(Panel00, "3");
				LshowNome00.setText(trab[0].getNome());
				LshowSexo00.setText(String.valueOf(trab[0].getSexo()));
				LshowIdade00.setText(String.valueOf(trab[0].getAnos()));
				LshowJob00.setText(trab[0].getJob());
				LshowMoney00.setText(String.valueOf(trab[0].getSalario()));
				
				LshowNome10.setText(trab[1].getNome());
				LshowSexo10.setText(String.valueOf(trab[1].getSexo()));
				LshowIdade10.setText(String.valueOf(trab[1].getAnos()));
				LshowJob10.setText(trab[1].getJob());
				LshowMoney10.setText(String.valueOf(trab[1].getSalario()));

			}
		});
		B21.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		B21.setBounds(241, 167, 165, 42);
		card2.add(B21);
		
	}
}
