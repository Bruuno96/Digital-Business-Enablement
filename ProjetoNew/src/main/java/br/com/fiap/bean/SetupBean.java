package br.com.fiap.bean;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.SetupDAO;
import br.com.fiap.model.Setup;
import br.com.fiap.model.User;


@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();
	
	public void save() {
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();

			User user = (User) sessionMap.get("user");
			setup.setUser(user);	
			System.out.println("ID: "+user.getId()+" Email: "+user.getEmail());
			new SetupDAO().create(setup);
			FacesContext.getCurrentInstance()
					.addMessage(null, new FacesMessage("Setup cadastrado com sucesso"));
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Erro ao cadastrar Setup"));

		}

	}
	
	public List<Setup> getSetups(){
		return new SetupDAO().getAll();
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
	

}
