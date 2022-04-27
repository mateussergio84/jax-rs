package br.com.teste.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.model.Pessoa;
import br.com.teste.service.Service;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class PessoaResource {

	Service service = new Service();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Pessoa addUser(Pessoa pessoa) {
		System.out.println("teste2");
		return service.insertUser(pessoa);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Pessoa> getUser() throws SQLException {
		return service.getUser();
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Pessoa> getUser(@PathParam("id") int id) throws SQLException {
		return service.getUserById(id);

	}

	@Path("/update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa updateUser(Pessoa p) {
		return service.updatetUser(p);
	}

	@Path("/delete/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteUser(@PathParam("id") int id) {
		return service.deletetUser(id);
	}
	
}
