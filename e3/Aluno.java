package ling1;

public class Aluno {
	private String nome;
	private char sexo;
	private int idade;
	private String curso;
	
	public Aluno(String nome, String curso, char sexo, int ano) {
		this.nome = nome;
		this.curso = curso;
		this.sexo = sexo;
		idade = ano;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public void setIdade(int ano) {
		idade = ano;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void estudar() {
		System.out.println(nome + " começou a estudar.");
	}
	
	public void cel() {
		System.out.println(nome + " está mexendo no celular!");
	}
	
	public void perguntar() {
		System.out.println(nome + " fez uma pergunta ao professor(a).");
	}
}
