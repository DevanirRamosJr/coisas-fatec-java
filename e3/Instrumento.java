package ling1;

public class Instrumento {
	private String nome;
	private String dono;
	private int ano;
	
	public Instrumento(String nome, String dono, int ano) {
		this.nome = nome;
		this.dono = dono;
		this.ano = ano;
	}
	
	public void setDono(String nome) {
		dono = nome;
	}
	
	public void setAnos(int ano) {
		this.ano = ano;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDono() {
		return dono;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void tocar() {
		System.out.println(nome + " começou a tocar.");
	}
	
	public void parar() {
		System.out.println(nome + " parou de tocar.");
	}
	
	public void limpar() {
		System.out.println(nome + " foi limpado.");
	}
	
	public void age() {
		if(ano > 7) {
			System.out.println(nome + " de " + dono + " já é um instrumento velho.");
		}
		else if(ano <= 1) {
			System.out.println(nome + " de " + dono +  " ainda é um instrumento novo.");
		}
		else {
			System.out.println(nome + " de " + dono +  " não é um instrumento novo nem velho.");
		}
	}
}
