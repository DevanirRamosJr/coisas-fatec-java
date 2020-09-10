package ling1;

public class Shoe {
	private String nome;
	private String dono;
	private int preco;
	
	public Shoe(String nome, String dono, int valor) {
		this.nome = nome;
		this.dono = dono;
		preco = valor;
	}
	
	public void setDono(String nome) {
		dono = nome;
	}
	
	public void setPreco(int valor) {
		preco = valor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDono() {
		return dono;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public void vestir() {
		System.out.println(nome + " foi vestido.");
	}
	
	public void andar() {
		System.out.println(dono + " começou a andar com o calçado.");
	}
	
	public void limpar() {
		System.out.println(nome + " foi limpado.");
	}
	
	public void preco() {
		if(preco > 200) {
			System.out.println(nome + " é caro.");
		}
		else if(preco < 130) {
			System.out.println(nome + " é barato.");
		}
		else {
			System.out.println(nome + " não é caro nem barato.");
		}
	}
}
