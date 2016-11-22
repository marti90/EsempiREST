package it.alfasoft.martina.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class Invocazioni {
	
	private Client cliente = ClientBuilder.newClient();
	private WebTarget basedTarget = cliente.target("http://localhost:8086/EsempioREST2/alfasoft");
	private WebTarget targetDipendenti = basedTarget.path("/dipendenti");
	
	public Invocazioni(){
		
	}
	
	public Invocation richiestaDipendenteConCodice(String codice){
		
		return targetDipendenti.path(codice).request().buildGet();
	}
	
	

}
