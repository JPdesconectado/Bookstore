package tabelaDeLivros;

import java.util.ArrayList;
import java.util.List;
import tabelaDeLivros.Livro;


public class Lista {


	private static List<Livro> livros;
			
	public Lista() {
		livros = new ArrayList<Livro>();
	}
	public void addLivros(Livro... liv) {
		for (Livro l : liv)
			livros.add(l);
	}
	
	public List<Livro> getLivros(){
		return livros;
	}

	}
