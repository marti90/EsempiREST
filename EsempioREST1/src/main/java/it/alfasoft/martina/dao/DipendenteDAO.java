package it.alfasoft.martina.dao;

import it.alfasoft.martina.model.Dipendente;

import java.util.Map;
import java.util.TreeMap;

public class DipendenteDAO {
	
	private Map<String,Dipendente> dipendenti = new TreeMap<String,Dipendente>();
	
	public DipendenteDAO(){
		Dipendente d1 = new Dipendente("01","Marti","Debe",1500);
		Dipendente d2 = new Dipendente("02","Luca","Umo",2000);
		Dipendente d3 = new Dipendente("03","Ire","Aimo",1000);
		Dipendente d4 = new Dipendente("04","Rita","Lauri",800);
		
		dipendenti.put(d1.getCodiceDip(), d1);
		dipendenti.put(d2.getCodiceDip(), d2);
		dipendenti.put(d3.getCodiceDip(), d3);
		dipendenti.put(d4.getCodiceDip(), d4);
		
	}

	public Map<String,Dipendente> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(Map<String,Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	

}
