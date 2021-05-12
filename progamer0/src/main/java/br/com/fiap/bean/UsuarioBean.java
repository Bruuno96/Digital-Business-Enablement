package br.com.fiap.bean;


import java.util.List;    

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

@Named
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	public void save() {
		new UsuarioDao().create(this.usuario);
		System.out.println(this.usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso"));
	}
	
	public List<Usuario> getAllUsers(){
		return new UsuarioDao().getAll();
	}

	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}


