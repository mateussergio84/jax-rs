package br.com.teste.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.teste.model.Pessoa;
import br.com.teste.service.Service;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class PessoaResource {

	Service service = new Service();

//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getIt() {
//		service.crudservice();
//		return "Got it!";
//	}

//	@Path("/Pessoa")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Pessoa addUser(Pessoa pessoa) {
		System.out.println("teste2");
		service.crudservice();
		return service.insertUser(pessoa);

	}

	// @Path("/Pessoa")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Pessoa> getUser() throws SQLException {
		service.crudservice();
		return service.getUser();
	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Pessoa> getUser(@PathParam("id") int id) throws SQLException {
		service.crudservice();
		return service.getUserById(id);

	}

	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Pessoa updateUser(Pessoa p) {
		return service.updatetUser(p);

	}

	@Path("/deleteUserById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteUser(@PathParam("id") int id) {
		return service.deletetUser(id);

	}

}
