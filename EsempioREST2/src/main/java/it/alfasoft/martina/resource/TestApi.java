package it.alfasoft.martina.resource;

import it.alfasoft.martina.bean.FiltriFattura;

import javax.ws.rs.BeanParam;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("test")
@Produces(MediaType.TEXT_PLAIN)     //Dobbiamo scrivere cosa ci produce il metodo
public class TestApi {
	
	@GET                            //Dobbiamo scrivere il metodo
	public String metodoProva(){
		return "Ciao!";
	}
	
	//
	@GET
	@Path("/head")
	public String getHeaderParameter(@HeaderParam("numero") int num){
		return "Il numero inserito e'= "+num;
	}
	
	//Metodo per prendere i parametri dai cookies
	@GET
	@Path("/cookie")
	public String getCookieParameter(@CookieParam("numero") int num){
		return "Il numero inserito e'= "+num;
	}
	
	// Metodo per prendere i parametri dal context
	@GET
	@Path("/context")
	public String getContextParameter(@Context UriInfo uriInfo,
			                          @Context HttpHeaders httpHeaders){
		//String s = httpHeaders.getCookies().toString();
		
		//Servirà per HATEOAS
		String path = uriInfo.getAbsolutePath().toString();
		return path;
		
	}
	
	//Metodo per prendere i BeanParam
	@GET
	@Path("/fattura")
	public String getBeanParam(@BeanParam FiltriFattura ff){
		
		return ff.getAnno()+" "+ff.getOffset()+" "+ff.getLimit();
	}
	

}
