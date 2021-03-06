package it.alfasoft.martina.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import it.alfasoft.martina.dao.DipendenteDAO;
import it.alfasoft.martina.model.Dipendente;

@Path("dipendenti")
public class RisorseDipendente {
	
	private DipendenteDAO dDao = new DipendenteDAO();
	
//	@Path("/{codiceDipendente}")
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public Dipendente getDipendente(@PathParam("codiceDipendente") String codiceDip){
//		
//		return dDao.getDipendenti().get(codiceDip);
//	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Dipendente> getDipendenti(){
//
//		return new ArrayList<Dipendente>(dDao.getDipendenti().values());
//	}
	
//	@Path("/{num}")
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String testConversione(@PathParam("num") double num){
//		
//		return num+" "+(num+num);
//	}
	
	@Path("/{codiceDipendente}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Dipendente getDipendenteByCode(@PathParam("codiceDipendente") String codiceDip,
			@Context UriInfo uri){
		
		Dipendente d = dDao.getDipendenti().get(codiceDip);
		String link= uri.getBaseUriBuilder()
				        .path(RisorseDipendente.class)
				        .path(codiceDip)
				        .build()
				        .toString();
		
		//d.addLink(link,"self");
		String linkBuste= uri.getBaseUriBuilder()
				             .path(RisorseDipendente.class)
				             .path(codiceDip) 
				             .path("bustePaga")
				             .build()
				             .toString();
		
		//d.addLink(linkBuste,"buste");
		
		return d;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response aggiungiDipendente(Dipendente d){
		
		dDao.getDipendenti().put(d.getCodiceDip(), d);
		System.out.println("Post arrivato!"+d.getNome()+" "+d.getCognome());
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void aggiornaDipendente(Dipendente d2){
		
		dDao.getDipendenti().put(d2.getCodiceDip(), d2);
		for(Dipendente d:dDao.getDipendenti().values()){
			System.out.println(d.getNome()+" "+d.getCognome());
		}
	}
	
	@Path("/{codiceDipendente}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void cancellaDipendente(@PathParam("codiceDipendente") String codiceDip){
		
		
		Dipendente d1 = dDao.getDipendenti().remove(codiceDip);
		
	    System.out.println(d1.getNome()+" "+d1.getCognome());
		
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Dipendente getDipendente(@QueryParam("codice") String codiceDip,
//			                        @QueryParam("numero") int n){
//		System.out.println("Valore ricevuto = "+n);
//		return dDao.getDipendenti().get(codiceDip);
//	}
	
	//Se viene scritto un URL di questo tipo:
	//http://localhost:8085/NomeApplicazione/webapi(o alfasoft dipende come lo definiamo)/dipendenti/{codice dipendente}
	//arriva a questo metodo e viene reindirizzato a RisorsaBuste
	@Path("/{codiceDipendente}/bustepaghe")
	public RisorsaBuste getBustePaghe(){
		return new RisorsaBuste();
	}

}
