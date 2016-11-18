package it.alfasoft.martina.client;

import it.alfasoft.martina.model.Dipendente;

import javax.ws.rs.core.Response;

public class InvocazioneProva {

	public static void main(String[] args) {
		
		Invocazioni invocazione = new Invocazioni();
		Response risposta = invocazione.richiestaDipendenteConCodice("01")
		                               .invoke();
		
		Dipendente d = risposta.readEntity(Dipendente.class);
		
		System.out.println(d.getNome()+" "+d.getCognome()+" "+d.getStipendio());

	}

}
