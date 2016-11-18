package it.alfasoft.martina.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dipendente {
	
	private String codiceDip;
	private String nome;
	private String cognome;
	private double stipendio;
	
	public Dipendente(){
		
	}

	public Dipendente(String codiceDip, String nome, String cognome, double stipendio) {
		this.setCodiceDip(codiceDip);
		this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public String getCodiceDip() {
		return codiceDip;
	}

	public void setCodiceDip(String codiceDip) {
		this.codiceDip = codiceDip;
	}

}
