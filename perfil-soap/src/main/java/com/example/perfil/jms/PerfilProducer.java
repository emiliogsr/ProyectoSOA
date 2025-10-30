package com.example.perfil.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PerfilProducer {

    private final JmsTemplate jmsTemplate;

    public PerfilProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    // Este método enviará un mensaje a la cola de Artemis
    public void sendPerfilResponse(String mensaje) {
        jmsTemplate.convertAndSend("perfil.response", mensaje);
        System.out.println("✅ Mensaje enviado a la cola perfil.response: " + mensaje);
    }
}
