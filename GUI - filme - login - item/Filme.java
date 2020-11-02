package ling1;

public class Filme {
	private String nome;
	private String data;
	private String local;
	private String tipo;

	public Filme() {
		
	}
	
	public Filme(String nome, String data, String local, String tipo) {
		this.nome = nome;
		this.data = data;
		this.local = local;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getData() {
		return data;
	}

	public String getLocal() {
		return local;
	}

	public String getTipo() {
		return tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean isValid() {
	    return nome != null && data != null && local != null && tipo != null;
	  }
}
