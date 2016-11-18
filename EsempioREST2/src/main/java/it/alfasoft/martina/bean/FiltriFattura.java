package it.alfasoft.martina.bean;

import javax.ws.rs.QueryParam;

public class FiltriFattura {
	
	//Sposto in una classe a parte i vari QueryParam, utile se ne ho tanti
	
	private @QueryParam("anno") int anno;
	private @QueryParam("offset") int offset;
	private @QueryParam("limit") int limit;
	
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}
