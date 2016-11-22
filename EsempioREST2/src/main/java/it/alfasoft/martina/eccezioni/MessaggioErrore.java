package it.alfasoft.martina.eccezioni;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessaggioErrore {
	
	private String errorMsg;
	private int errorCode;
	private String linkRedirect;
	
	public MessaggioErrore(){
		
	}

	public MessaggioErrore(String errorMsg, int errorCode, String linkRedirect) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.linkRedirect = linkRedirect;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getLinkRedirect() {
		return linkRedirect;
	}

	public void setLinkRedirect(String linkRedirect) {
		this.linkRedirect = linkRedirect;
	}
	
	

}
