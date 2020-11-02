
package ling1;


public class Testando {

	public static void main (String[]args) {

		String [] nomes = {"Aline", "Alejandro", "Carla", "Daniel",  "Karen", "Heitor", 
				"Maria", "Marcos", "Sophia", "Roberto"};
	
		Aluno[] aluno = new Aluno[4];
		aluno[0] = new Aluno(nomes[0], "BD", 'F', 20);
		aluno[1] = new Aluno(nomes[2], "GP!", 'F', 25);
		aluno[2] = new Aluno(nomes[1], "Manutenção", 'M', 26);
		aluno[3] = new Aluno(nomes[5], "BD", 'M', 19);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Nome: " + aluno[i].getNome() + 
					"\nCurso: " + aluno[i].getCurso() + 
					"\nIdade: " + aluno[i].getIdade());
			aluno[i].estudar();
			aluno[i].perguntar();
			aluno[i].cel();
			System.out.println("___________________________\n");
		}
		
		System.out.println("############################\n");
	
		Instrumento[] inst = new Instrumento[4];
		inst[0] = new Instrumento("Clarinete", nomes[4], 10);
		inst[1] = new Instrumento("Piano", nomes[8], 1);
		inst[2] = new Instrumento("Bateria", nomes[3], 2);
		inst[3] = new Instrumento("Triângulo", nomes[9], 5);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Nome: " + inst[i].getDono() + 
					"\nInstrumento: " + inst[i].getNome() + 
					"\nToca a " + inst[i].getAno() + " anos.");
			inst[i].tocar();
			inst[i].parar();
			inst[i].limpar();
			inst[i].age();
			System.out.println("___________________________\n");
		}
		
		System.out.println("############################\n");
	
		Job[] trab = new Job[4];
		trab[0] = new Job(nomes[2], "Professor", 30, 5000);
		trab[1] = new Job(nomes[7], "Eletricista", 25, 7300);
		trab[2] = new Job(nomes[9], "Desenvolvedor de Software", 34, 9500);
		trab[3] = new Job(nomes[5], "Mecânica", 27, 2400);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Nome: " + trab[i].getNome() + 
					"\nTrabalho: " + trab[i].getJob() + 
					"\nIdade" + trab[i].getAnos());
			trab[i].trabalhar();
			trab[i].fim();
			trab[i].salario();
			System.out.println("___________________________\n");
		}
		
		System.out.println("############################\n");
		
		Lugar[] lugar = new Lugar[4];
		lugar[0] = new Lugar("Rio de Janeiro", "Brasil", 35);
		lugar[1] = new Lugar("Porto Alegre", "Brasil", 27);
		lugar[2] = new Lugar("Veneza", "Itália", 20);
		lugar[3] = new Lugar("Monte Fuji", "Japão", 2);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Local: " + lugar[i].getNome() + 
					"\nPaís: " + lugar[i].getPais());
			lugar[i].elogio();
			lugar[i].turismo();
			lugar[i].temp();
			System.out.println("___________________________\n");
		}
		
		System.out.println("############################\n");
		
		Pessoa[] pes = new Pessoa[4];
		pes[0] = new Pessoa(nomes[6], 'F', 30);
		pes[1] = new Pessoa(nomes[8], 'F', 25);
		pes[2] = new Pessoa(nomes[7], 'M', 58);
		pes[3] = new Pessoa(nomes[1], 'M', 16);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Nome: " + pes[i].getNome() + 
					"\nIdade: " + pes[i].getIdade());
			pes[i].oi();
			pes[i].hru();
			pes[i].bye();
			pes[i].age();
			System.out.println("___________________________\n");
		}
		
		System.out.println("############################\n");
	
		Shoe[] shoe = new Shoe[4];
		shoe[0] = new Shoe("Tênis Puma", nomes[6], 140);
		shoe[1] = new Shoe("Sapato Social", nomes[7], 200);
		shoe[2] = new Shoe("Scarpin", nomes[8], 190);
		shoe[3] = new Shoe("Sapatênis", nomes[5], 120);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Dono: " + shoe[i].getDono() + 
					"\nSapato: " + shoe[i].getNome());
			shoe[i].vestir();
			shoe[i].andar();
			shoe[i].limpar();
			shoe[i].preco();
			System.out.println("___________________________\n");
		}
		
	}
}

