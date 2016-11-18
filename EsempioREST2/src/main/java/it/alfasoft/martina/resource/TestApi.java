package it.alfasoft.martina.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestApi {
	
	@GET                                //Dobbiamo scrivere il metodo
	@Produces(MediaType.TEXT_PLAIN)     //Dobbiamo scrivere cosa ci produce il metodo
	public String metodoProva(){
		return "Ciao!";
	}
	

}
