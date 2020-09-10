package ling1;

public class Pessoa {
	private String nome;
	private char sexo;
	private int idade;
	
	public Pessoa(String nome, char sexo, int ano) {
		this.nome = nome;
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
	
	public char getSexo() {
		return sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void oi() {
		System.out.println(nome + " diz: Olá!");
	}
	
	public void hru() {
		System.out.println(nome + " diz: Estou bem!");
	}
	
	public void bye() {
		System.out.println(nome + " diz: Até mais.");
	}
	
	public void age() {
		if(idade > 50) {
			System.out.println(nome + " já é velho(a).");
		}
		else if(idade < 20) {
			System.out.println(nome + " ainda é jovem.");
		}
		else {
			System.out.println(nome + " não é jovem nem velho(a).");
		}
	}
}
