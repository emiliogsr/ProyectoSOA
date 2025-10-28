/**
 * 
 */
package com.example.dto;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.example.common.AppException;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;

/**
 * Clase reprensenta un mensaje JMS.
 */
public class JmsMessage {

	/** Contiene el texto del mensaje JMS. */
	private String message;

	/**
	 * Contiene las propiedades del mensaje JMS.
	 */
	private Map<String, String> properties;

	/** Cola de salida. */
	private String outQueue;

	/**
	 * Constructor.
	 * 
	 * @param message
	 * @throws JMSException
	 */
	@SuppressWarnings("rawtypes")
	public JmsMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			this.message = textMessage.getText();
			// Inicializa el mapa de propiedades.
			properties = new HashMap<>();
			Enumeration propertyNames = textMessage.getPropertyNames();
			// Por cada propiedad del mensaje JMS, la añade al mapa.
			while (propertyNames.hasMoreElements()) {
				// Obtiene el nombre de la propiedad.
				String propertyName = (String) propertyNames.nextElement();
				if (propertyName.startsWith("JMS")) {
					// Ignora las propiedades JMS.
					continue;
				}
				// Añade la propiedad al mapa.
				properties.put(propertyName, textMessage.getStringProperty(propertyName));
			}
		} catch (JMSException e) {
			e.printStackTrace();
			throw new AppException(e);
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param message  El texto del mensaje.
	 * @param headers  Las propiedades del mensaje.
	 * @param queueOut La cola de salida.
	 */
	public JmsMessage(String message, Map<String, String> headers, String queueOut) {
		this.message = message;
		this.properties = headers;
		this.outQueue = queueOut;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the properties
	 */
	public final Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public final void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	
	/**
	 * Representación String del objeto.
	 */
	public String toString() {
		return "JmsMessage [message=" + message + ", properties=" + properties + "]";
	}

	/**
	 * @return the outQueue
	 */
	public final String getOutQueue() {
		return outQueue;
	}

	/**
	 * @param outQueue the outQueue to set
	 */
	public final void setOutQueue(String outQueue) {
		this.outQueue = outQueue;
	}
}
