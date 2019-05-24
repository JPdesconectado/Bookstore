package tabelaDeLivros;

public class Livro {
	
	private String nome;
	private String cod;
	private String ano;
	private String autor;
	private String editora;
	
	public Livro(String nome, String cod, String ano, String autor, String editora){
		this.nome = nome;
		this.cod = cod;
		this.ano = ano;
		this.autor = autor;
		this.editora = editora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
}
