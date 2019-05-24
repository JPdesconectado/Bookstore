package tabelaDeEmprestimos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tabelaDeLivros.Livro;

public class Emprestimo {

	private static List<Livro> livros;
	
	public Emprestimo() {
		livros = new ArrayList<Livro>();
	}
	
	public void addLivros(Livro... li) {
		for (Livro l : li)
			livros.add(l);
	}
	
	public void removerLivro(Livro l) {
		Iterator<Livro> itLivro = livros.iterator();
		while (itLivro.hasNext()) {
			Livro livro = itLivro.next();
			if (livro.getNome().equals(l.getNome()) && livro.getCod().equals(l.getCod()) && 
				livro.getAno().equals(l.getAno()) && 
				livro.getAutor().equals(l.getAutor()) && 
				livro.getEditora().equals(l.getEditora())){
				itLivro.remove();
			}
		}
	}
	
	public List<Livro> getLivros(){
		return livros;
	}
}
