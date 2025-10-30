package edu.itq.soa.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import edu.itq.soa.ValidarRequest;
import edu.itq.soa.ValidarResponse;
import edu.itq.soa.business.Usuario;

/**
 * Endpoint SOAP para el nombre
 */
@Endpoint
public class UsuarioEndpoint {
	private static final String NAMESPACE_URI = "http://itq.edu/soa";

	/** Servicio de cálculo. */
	private Usuario usuario;

	/**
	 * Constructor que inyecta el servicio de cálculo.
	 * 
	 * @param calculator El servicio de cálculo.
	 */
	public UsuarioEndpoint(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Maneja las solicitudes de cálculo.
	 * 
	 * @param request La solicitud de cálculo.
	 * @return La respuesta con el resultado del cálculo.
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "validarRequest")
	@ResponsePayload
	public ValidarResponse validar(@RequestPayload ValidarRequest request) {
		return usuario.validar(request);
	}
}