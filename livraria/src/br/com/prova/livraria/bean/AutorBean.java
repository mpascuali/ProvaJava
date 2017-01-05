package br.com.prova.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prova.livraria.dao.AutorDao;
import br.com.prova.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	
	private Integer autorId;
	
	private AutorDao daoA = new AutorDao();

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public void carregarAutorPelaId() {
		this.autor = daoA.buscaPorId(autorId);
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if(this.autor.getId() == null) {
			
			for (Autor autorDaLista : daoA.LSAutor) {
				if(autorDaLista.getEmail().equalsIgnoreCase(this.autor.getEmail()) && autorDaLista.getNome().equalsIgnoreCase(this.autor.getNome())){
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Autor Já Cadastrado"));
					return "";
				}
			}
			
			daoA.adiciona(this.autor);
			this.autor = new Autor();
			return "livro?faces-redirect=true";
		} else {
			daoA.atualiza(this.autor);
			return "autor?faces-redirect=true";
		}
	}
	
	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());
		daoA.remove(autor);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Autor " + autor.getNome() + " foi removido"));
	}
	
	public int getQtdLivro(){
		//TODO retornar a quantdade de livros do autor
		return 0;
	}
	
	public List<Autor> getAutores() {
		return daoA.listaTodos();
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
