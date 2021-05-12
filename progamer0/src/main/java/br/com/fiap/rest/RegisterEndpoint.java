package br.com.fiap.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

@Path("/registers")
@Produces(MediaType.APPLICATION_JSON)
public class RegisterEndpoint {
	
	private UsuarioDao dao = new UsuarioDao();
	
	@GET
	public List<Usuario> index() {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Usuario usuario) {
		if (usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		dao.create(usuario);
		return Response.status(Response.Status.CREATED).entity(usuario).build();
	}
	
	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		Usuario usuario;
		try {
			usuario = dao.findById(id);
			if (usuario == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.status(Response.Status.OK).entity(usuario).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Usuario usuario) {
		usuario.setIdperson(id);
		dao.update(usuario);
		return Response.status(Response.Status.OK).entity(usuario).build();
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id, Usuario usuario) {
		usuario = dao.findById(id);
		dao.remove(usuario);
		return Response.status(Response.Status.OK).entity(usuario).build();
	}

}
