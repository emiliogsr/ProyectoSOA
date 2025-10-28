/**
 * 
 */
package com.example.jms;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.business.ValidadorUsuarios;
import com.example.dto.JmsMessage;
import com.example.dto.Request;
import com.example.dto.Response;
import com.google.gson.Gson;

import jakarta.jms.Message;

/**
 * Clase para consumir mensajes de un broker JMS.
 */
@Component
public class Consumer {
	@Autowired
	private ValidadorUsuarios validadorusuarios;

	@Autowired
	private JmsSender jmsSender;
	
	@JmsListener(destination = "queue")
	public void receiveMessage(Message message) {
		JmsMessage jmsMessage = new JmsMessage(message);
		System.out.println("Received message: " + jmsMessage.getMessage());
		Gson gson = new Gson();
		Request request = gson.fromJson(jmsMessage.getMessage(), Request.class);
		Response response = validadorusuarios.validar(request);
		String json = gson.toJson(response);
		String queueOut = "queue-out";
		JmsMessage outMsg = new JmsMessage(json, null, queueOut);
		jmsSender.send(outMsg);
//		jmsSender.send(json, queueOut);
		}
}
