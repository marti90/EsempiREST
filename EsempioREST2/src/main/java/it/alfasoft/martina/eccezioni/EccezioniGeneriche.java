package it.alfasoft.martina.eccezioni;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EccezioniGeneriche implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		
		MessaggioErrore msg = new MessaggioErrore(ex.getMessage(),
				                                  500,
				                                  "google.com");

		return Response.status(Status.INTERNAL_SERVER_ERROR)
				       .entity(msg)
				       .build();
	}
	
	

}
