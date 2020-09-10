package ling1;

public class Job {
	private String job;
	private String nome;
	private int idade;
	private int salario;
	
	public Job(String nome, String job, int ano, int salario) {
		this.nome = nome;
		this.job = job;
		idade = ano;
		this.salario = salario;
	}
	
	public void setAnos(int ano) {
		idade = ano;
	}
	
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getJob() {
		return job;
	}
	
	public int getAnos() {
		return idade;
	}
	
	public int getSalario() {
		return salario;
	}
	
	public void salario () {
		if(salario > 6000) {
			System.out.println(nome + " recebe bastante como " + job + ".");
		}
		else if(salario < 2500) {
			System.out.println(nome + " recebe pouco como " + job + ".");
		}
		else {
			System.out.println(nome + " recebe moderado como " + job + ".");
		}
	}
	
	public void trabalhar() {
		System.out.println(nome + " foi trabalhar como " + job + ".");
	}
	
	public void fim() {
		System.out.println(nome + " voltou do trabalho.");
	}
}
