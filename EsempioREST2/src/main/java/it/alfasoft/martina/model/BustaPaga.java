package it.alfasoft.martina.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BustaPaga {
	
	private long id_busta;
	private double importo;
	private String codiceDip;
	
	public BustaPaga(){
		
	}
	
	public BustaPaga(long id_busta, double importo, String codiceDip) {
		this.id_busta = id_busta;
		this.importo = importo;
		this.codiceDip=codiceDip;
	}
	
	public long getId_busta() {
		return id_busta;
	}
	public void setId_busta(long id_busta) {
		this.id_busta = id_busta;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}

	public String getCodiceDip() {
		return codiceDip;
	}

	public void setCodiceDip(String codiceDip) {
		this.codiceDip = codiceDip;
	}
	
	

}
