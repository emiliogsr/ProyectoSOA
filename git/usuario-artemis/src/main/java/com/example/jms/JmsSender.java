/**
 * 
 */
package com.example.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.dto.JmsMessage;

/**
 * 
 */
@Service
public class JmsSender {
	/**
	 * Plantilla JMS para enviar mensajes proporcionada 
	 * e instanciada por Spring.
	 */
	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * Envía un mensaje JMS a la cola especificada en el mensaje.
	 * 
	 * @param outMsg Información del mensaje JMS a enviar.
	 */
	public void send(JmsMessage outMsg) {
		jmsTemplate.send(outMsg.getOutQueue(), session -> {
			// Crea un mensaje de texto JMS con el contenido del mensaje.
			jakarta.jms.TextMessage txtMessage = session.createTextMessage(outMsg.getMessage());
			// Añade las propiedades al mensaje JMS.
			if (outMsg.getProperties() != null) {
				outMsg.getProperties().forEach((key, value) -> {
					try {
						txtMessage.setStringProperty(key, value);
					} catch (jakarta.jms.JMSException e) {
						e.printStackTrace();
					}
				});
			}
			return txtMessage;
		});
		System.out.println("Sent response: " + outMsg.getMessage() + " to queue " + outMsg.getOutQueue());
	}
}
