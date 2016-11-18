package it.alfasoft.martina.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import it.alfasoft.martina.dao.BustaPagaDAO;
import it.alfasoft.martina.model.BustaPaga;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RisorsaBuste {
	
	BustaPagaDAO bDao= new BustaPagaDAO();
	
	@Path("{id_busta}")
	@GET
	public BustaPaga getBustaPagaConId(@PathParam("id_busta") long id_busta){
		
		return bDao.getBuste().get(id_busta);
	}
	
	@GET
	public List<BustaPaga> getTutteBuste(){
		return new ArrayList<BustaPaga>(bDao.getBuste().values());
	}
	
	@Path("/{id_busta}/{num}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getBusta(@PathParam("id_busta") long id_busta,
			               @PathParam("codiceDipendente") String codiceDip,
			               @PathParam("num") int num){
		return id_busta+" "+codiceDip+" "+num;
		
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response addBusta(BustaPaga b, @Context UriInfo uri){
//		
//		bDao.getBuste().put(b.getId_busta(), b);
//		URI u = uri.getAbsolutePathBuilder().path(String.valueOf(b.getId_busta())).build();
//		
//		return Response.created(u).entity(b).build();
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBusta(BustaPaga b, @Context UriInfo uri){
		
		bDao.getBuste().put(b.getId_busta(), b);
		
		return Response.status(Status.CREATED).entity(b).build();
	}
	

}
