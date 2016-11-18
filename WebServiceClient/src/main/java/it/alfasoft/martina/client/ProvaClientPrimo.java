package it.alfasoft.martina.client;

import java.util.List;

import it.alfasoft.martina.model.Dipendente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


public class ProvaClientPrimo {

	public static void main(String[] args) {
		
		//il pattern secondo il quale viene utilizzato un metodo statico per
		//creare un oggetto Client 
		//si chiama Factory Pattern
		Client cliente = ClientBuilder.newClient();
		
		//target di base al quale aggiungiamo dei pezzi a seconda di quello che vogliamo fare
		WebTarget basedTarget = cliente.target("http://localhost:8086/EsempioREST2/alfasoft");
		
		//facciamo una richiesta a questo se vogliamo tornare una lista
		WebTarget targetDipendenti = basedTarget.path("/dipendenti");
		
		//per prendere un singolo dipendente
		WebTarget singoloDipendente = targetDipendenti.path("/{codiceDip}");
		
		//dobbiamo mettere in target l'indirizzo http. request() torna un builder,
		//vogliamo fare ancora un get. Questo sarà un GET Request, quindi mando una
		//richiesta di tipo GET all'indirizzo specificato
//		Response response = singoloDipendente
//				                   .resolveTemplate("codiceDip", "01")
//		                           .request()
//		                           .get();
//		
//		Dipendente d = response.readEntity(Dipendente.class);
//		System.out.println(d.getNome()+" "+d.getCognome());
//		
//		Dipendente d2 = new Dipendente("05","Orne","Deb",5000);
//		
//		Response responsePOST = targetDipendenti.request().post(Entity.json(d2));
//		
//		if(responsePOST.getStatus()!=201){
//			System.out.println("Qualcosa è andato male!");
//		}
//		System.out.println(responsePOST.getStatus());
		
		Response response= targetDipendenti.request().get();
		
		List<Dipendente> dipendenti = response.readEntity(new GenericType<List<Dipendente>>(){});
		
		for(Dipendente dd : dipendenti){
			System.out.println(dd.getNome()+" "+dd.getCognome()+" "+dd.getStipendio());
		}
				                      

	}

}
