package br.com.prova.livraria.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Livro;

public class AutorDao {

	public static ArrayList<Autor> LSAutor = new ArrayList<Autor>();

	public void pesist(Autor autor) {
		LSAutor.add(autor);
	}

	public void drop() {
		// TODO Auto-generated method stub
		LSAutor.clear();
	}

	public List<Autor> listaTodos() {
		// TODO Auto-generated method stub
		return LSAutor;
	}

	public Autor buscaPorId(Integer autorId) {

		// TODO Auto-generated method stub
		for (Autor autor : LSAutor) {
			if (autorId == autor.getId()) {
				return autor;
			}
		}

		return null;

	}

	public void remove(Autor autor) {
		LSAutor.remove(autor);
	}

	public void adiciona(Autor autor) {
		LSAutor.add(autor);
	}

	public void atualiza(Autor autor) {
		for (int i = 0; i < LSAutor.size(); i++) {
			if(LSAutor.get(i).getId() == autor.getId()){
				LSAutor.get(i).setEmail(autor.getEmail());
				LSAutor.get(i).setNome(autor.getNome());
				break;
			}
		}
	}
}
