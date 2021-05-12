package br.com.fiap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Setup;
import br.com.fiap.model.Usuario;

@RequestScoped
public class UsuarioDao {
	
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("progamer0");
		EntityManager em = fabrica.createEntityManager();

	public void create(Usuario usuario) {

		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

	public List<Usuario> getAll() {
		String jpql = "SELECT u FROM Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}
	
	public Usuario findById(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public void update(Usuario user) {
		em.getTransaction().begin();
		em.merge(user);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}

	public void remove(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
		em.close();
	}

	
	

}
