package ling1;

public class Planet {
	private String nome;
	private String cor;
	private String ano;
	private String dia;
	private int raio;
	private float distancia;
	private int temp_min;
	private int temp_max;
	private int temp_med;
	
	public Planet (String nome, String cor, String ano, String dia, int raio, float distancia, int min, int max, int med) {
		this.nome = nome;
		this.cor = cor;
		this.ano = ano;
		this.dia = dia;
		this.raio = raio;
		this.distancia = distancia;
		temp_min = min;
		temp_max = max;
		temp_med = med;
	}

	public Planet (String nome, String cor, String ano, String dia, int raio, float distancia, int med) {
		this.nome = nome;
		this.cor = cor;
		this.ano = ano;
		this.dia = dia;
		this.raio = raio;
		this.distancia = distancia;
		temp_med = med;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCor() {
		return cor;
	}

	public String getAno() {
		return ano;
	}

	public String getDia() {
		return dia;
	}

	public int getRaio() {
		return raio;
	}

	public float getDistancia() {
		return distancia;
	}

	public int getTemp_min() {
		return temp_min;
	}

	public int getTemp_max() {
		return temp_max;
	}

	public int getTemp_med() {
		return temp_med;
	}

	public void setTemp_min(int temp_min) {
		this.temp_min = temp_min;
	}

	public void setTemp_max(int temp_max) {
		this.temp_max = temp_max;
	}

	public void setTemp_med(int temp_med) {
		this.temp_med = temp_med;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	
}
