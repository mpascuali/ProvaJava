package br.com.prova.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prova.livraria.dao.UsuarioDao;
import br.com.prova.livraria.modelo.Autor;
import br.com.prova.livraria.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private UsuarioDao daoU = new UsuarioDao();
	
	public String gravar(){
		
		if(usuario.getId() == null){
			daoU.pesist(usuario);
		} else {
			daoU.atualiza(usuario);
		}
		return "livro?faces-redirect=true";
	}
	
	public void remover(Usuario usuario){
		daoU.remover(usuario);
	}
	
	public List<Usuario> getUsuarios() {
		return daoU.listaTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
